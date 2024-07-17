package com.ntconsult.hotel.application.ports.in;

import com.ntconsult.hotel.adapters.out.repository.entity.ReservaEntity;
import com.ntconsult.hotel.application.core.domain.Hotel;
import com.ntconsult.hotel.application.core.domain.Reserva;

import java.util.Optional;

public interface ReservaInputPort {

    void update(Long id);
    void insert(Reserva reserva);
    void delete(Reserva reserva);
    ReservaEntity find(Long id);
}
