package com.ntconsult.hotel.adapters.out;

import com.ntconsult.hotel.adapters.out.repository.HotelRepository;
import com.ntconsult.hotel.adapters.out.repository.entity.HotelEntity;
import com.ntconsult.hotel.adapters.out.repository.entity.QuartoEntity;
import com.ntconsult.hotel.adapters.out.repository.mapper.HotelEntityMapper;
import com.ntconsult.hotel.application.core.domain.*;
import com.ntconsult.hotel.application.ports.out.HotelOutputPort;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class HotelAdapter implements HotelOutputPort {

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    HotelEntityMapper hotelEntityMapper;

    @Override
    public void update(Hotel hotel) {

    }

    @Override
    public void insert(Hotel hotel) {
        var hotelEntity = hotelEntityMapper.toHotelEntity(hotel);
        hotelRepository.save(hotelEntity);
    }

    @Override
    public void delete(Hotel hotel) {

    }

    @Override
    public Optional<Hotel> find(Long id) {
        var hotelEntity = hotelRepository.findById(id);
        return hotelEntity.map(hotel -> hotelEntityMapper.toHotel(hotelEntity.get()));
    }
    @Override
    public List<Hotel> findHotelFiltro(HotelFiltro hotelFiltro) {
    var hotelEntity =  this.getAvailableHotels(hotelFiltro.getDestino(), hotelFiltro.getCheckIn()
      ,hotelFiltro.getCheckOut(),hotelFiltro.getQtdQuarto().longValue(),hotelFiltro.getQtdHospedes().longValue());
        List<Hotel> hotels = hotelEntity.stream()
                .map(hotelEntityMapper::toHotel)
                .collect(Collectors.toList());
     return hotels;
    }

    public List<HotelEntity> getAvailableHotels(String endereco, LocalDate checkIn, LocalDate checkOut, Long numQuartos, Long hospede) {
        Specification<HotelEntity> specification = HotelRegraAvancada.buildSpecification(endereco, hospede, numQuartos);
        List<HotelEntity> results = hotelRepository.findAll(specification);

        if (hospede != null) {
            results.forEach(hotel -> hotel.setQuartos(filterQuartos(hotel.getQuartos(), hospede)));
        }
        return results;
    }

    @Override
    public List<Hotel> findHotelFiltroOpcoes(HotelFiltro hotelFiltro) {
        var hotelEntity =  this.compareHotels(hotelFiltro.getDestino(),hotelFiltro.getPreco()
                                             ,hotelFiltro.getComodidade(),hotelFiltro.getAvaliacao());
        List<Hotel> hotels = hotelEntity.stream()
                .map(hotelEntityMapper::toHotel)
                .collect(Collectors.toList());
        return hotels;
    }


    public List<HotelEntity> compareHotels(String endereco, Double preco, String comodidade, Integer avaliacao) {
        Specification<HotelEntity> specs = Specification
                .where(HotelRegraConsulta.hasEndereco(endereco))
                .and(HotelRegraConsulta.hasPreco(preco))
                .and(HotelRegraConsulta.hasComodidade(comodidade));

        List<HotelEntity> hotels = hotelRepository.findAll(specs);

        hotels.forEach(hotel -> hotel.setQuartos(filterQuartosAvancado(hotel.getQuartos(), preco, comodidade)));

        if (avaliacao != null) {
            hotels = hotels.stream()
                    .filter(hotel -> calculateAverageAvaliacao(hotel) >= avaliacao)
                    .collect(Collectors.toList());
        }
        return hotels;
    }

    private List<QuartoEntity> filterQuartosAvancado(List<QuartoEntity> quartos, Double preco, String comodidade) {
        return quartos.stream()
                .filter(quarto -> (preco == 0 || quarto.getPreco() == (preco) ||  quarto.getPreco() <= (preco)) &&
                        (comodidade == null || quarto.getComodidade().equalsIgnoreCase(comodidade)))
                .collect(Collectors.toList());
    }

    private List<QuartoEntity> filterQuartos(List<QuartoEntity> quartos, Long hospedes) {
        return quartos.stream()
                .filter(quarto -> (hospedes == null || quarto.getHospedes() == (hospedes.intValue())))
                .collect(Collectors.toList());
    }

    private double calculateAverageAvaliacao(HotelEntity hotel) {
        return hotel.getAvaliacao().stream().mapToInt(Integer::intValue).average().orElse(0);
    }

}

