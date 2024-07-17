package com.ntconsult.hotel.adapters.out;

import com.ntconsult.hotel.adapters.in.controller.mapper.ReservaMapper;
import com.ntconsult.hotel.adapters.out.repository.ReservaRepository;
import com.ntconsult.hotel.adapters.out.repository.entity.ReservaEntity;
import com.ntconsult.hotel.adapters.out.repository.mapper.HotelEntityMapper;
import com.ntconsult.hotel.adapters.out.repository.mapper.QuartoMapper;
import com.ntconsult.hotel.adapters.out.repository.mapper.ReservaEntityMapper;
import com.ntconsult.hotel.application.core.domain.Hotel;
import com.ntconsult.hotel.application.core.domain.Quarto;
import com.ntconsult.hotel.application.core.domain.Reserva;
import com.ntconsult.hotel.application.ports.out.ReservaOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ReservaAdapter implements ReservaOutputPort {

    @Autowired
    ReservaRepository reservaRepository;

    @Autowired
    ReservaEntityMapper reservaEntityMapper;

    @Autowired
    HotelEntityMapper hotelEntityMapper;

    @Autowired
    QuartoMapper quartoMapper;

    @Override
    public void update(Long id) {
        reservaRepository.updateStatusToPago(id);
    }

    @Override
    public void insert(Reserva reserva) {
        var reservaEntity = reservaEntityMapper.toReservaEntity(reserva);
        reservaRepository.save(reservaEntity);

    }

    @Override
    public void delete(Reserva reserva) {
        reservaRepository.updateStatusToPago(reserva.getId());

    }

    @Override
    public ReservaEntity find(Long id) {
        var reservaEntity = reservaRepository.findById(id);
        var reserva = reservaEntityMapper.toReservaOptional(reservaEntity);
        return reservaEntity.get();
    }

    @Override
    public Optional<Reserva> buscaPorHoteleQuarto(Hotel hotel, Quarto quarto) {
        var hotelEntity = hotelEntityMapper.toHotelEntity(hotel);
        var quartoEtity = quartoMapper.toEntity(quarto);
        var reserva = reservaRepository.findByHotelAndQuarto(hotelEntity, quartoEtity);
        return reserva.map(reservaEntity -> reservaEntityMapper.toReserva(reservaEntity));
    }

}
