package com.ntconsult.hotel.application.ports.out;

import com.ntconsult.hotel.adapters.out.repository.entity.HotelEntity;
import com.ntconsult.hotel.application.core.domain.Hotel;
import com.ntconsult.hotel.application.core.domain.Quarto;

import java.util.Optional;

public interface QuartoOutputPort {

    void update(Quarto quarto);
    void insert(Quarto quarto);
    void delete(Quarto quarto);
    Optional<Quarto> find(Long id, Hotel hotelEntity);
}
