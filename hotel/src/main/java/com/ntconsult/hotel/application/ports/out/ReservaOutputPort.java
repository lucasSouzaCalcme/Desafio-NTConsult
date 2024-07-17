package com.ntconsult.hotel.application.ports.out;

import com.ntconsult.hotel.adapters.out.repository.entity.ReservaEntity;
import com.ntconsult.hotel.application.core.domain.Hotel;
import com.ntconsult.hotel.application.core.domain.Quarto;
import com.ntconsult.hotel.application.core.domain.Reserva;

import java.util.Optional;

public interface ReservaOutputPort {

    void update(Long id);
    void insert(Reserva reserva);
    void delete(Reserva reserva);
    ReservaEntity find(Long id);
    Optional<Reserva> buscaPorHoteleQuarto(Hotel hotel, Quarto quarto);
}
