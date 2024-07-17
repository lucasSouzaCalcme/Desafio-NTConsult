package com.ntconsult.hotel.application.ports.out;

import com.ntconsult.hotel.application.core.domain.Hotel;
import com.ntconsult.hotel.application.core.domain.HotelFiltro;

import java.util.List;
import java.util.Optional;

public interface HotelOutputPort {

    void update(Hotel hotel);
    void insert(Hotel hotel);
    void delete(Hotel hotel);
    Optional<Hotel> find(Long id);
    List<Hotel> findHotelFiltro(HotelFiltro hotelFiltro);
    List<Hotel> findHotelFiltroOpcoes(HotelFiltro hotelFiltro);
}
