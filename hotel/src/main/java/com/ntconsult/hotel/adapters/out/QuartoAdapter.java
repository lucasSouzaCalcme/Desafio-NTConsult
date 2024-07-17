package com.ntconsult.hotel.adapters.out;

import com.ntconsult.hotel.adapters.in.controller.mapper.HotelMapper;
import com.ntconsult.hotel.adapters.out.repository.QuartoRepository;
import com.ntconsult.hotel.adapters.out.repository.entity.HotelEntity;
import com.ntconsult.hotel.adapters.out.repository.mapper.HotelEntityMapper;
import com.ntconsult.hotel.adapters.out.repository.mapper.QuartoMapper;
import com.ntconsult.hotel.application.core.domain.Hotel;
import com.ntconsult.hotel.application.core.domain.Quarto;
import com.ntconsult.hotel.application.ports.out.QuartoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class QuartoAdapter implements QuartoOutputPort {

    @Autowired
    QuartoRepository quartoRepository;

    @Autowired
    QuartoMapper quartoMapper;

    @Autowired
    HotelEntityMapper hotelMapper;

    @Override
    public void update(Quarto quarto) {

    }

    @Override
    public void insert(Quarto quarto) {

    }

    @Override
    public void delete(Quarto quarto) {

    }

    @Override
    public Optional<Quarto> find(Long id, Hotel hotel) {
        var hotelEntity = hotelMapper.toHotelEntity(hotel);
        var quartoEntity =  quartoRepository.findByIdAndHotel(id, hotelEntity);
        return quartoEntity.map(quarto -> quartoMapper.toQuarto(quartoEntity.get()));
    }

}
