package com.ntconsult.hotel.application.core.usecase;

import com.ntconsult.hotel.application.core.domain.Hotel;
import com.ntconsult.hotel.application.core.domain.HotelFiltro;
import com.ntconsult.hotel.application.ports.in.HotelInputPort;
import com.ntconsult.hotel.application.ports.out.HotelOutputPort;

import java.util.List;
import java.util.Optional;

public class HotelUseCase implements HotelInputPort {

    private HotelOutputPort hotelOutputPort;

    public HotelUseCase(HotelOutputPort hotelOutputPort)
    {
        this.hotelOutputPort = hotelOutputPort;
    }

    @Override
    public void update(Hotel hotel) {
        hotelOutputPort.update(hotel);
    }

    @Override
    public void insert(Hotel hotel) {
        //hotel.getQuartos().forEach(quarto -> quarto.setHotel(hotel));
        hotelOutputPort.insert(hotel);

    }

    @Override
    public void delete(Hotel hotel) {
        hotelOutputPort.delete(hotel);
    }

    @Override
    public Optional<Hotel> find(Long id) {
        return Optional.ofNullable(hotelOutputPort.find(id)
                .orElseThrow(() -> new RuntimeException("Nenhum hotel encontrado"))
        );
    }

    @Override
    public List<Hotel> findHotelFiltro(HotelFiltro hotelFiltro) {
        return hotelOutputPort.findHotelFiltro(hotelFiltro);
    }

    @Override
    public List<Hotel> findHotelFiltroOpcoes(HotelFiltro hotelFiltro) {
        return hotelOutputPort.findHotelFiltroOpcoes(hotelFiltro);
    }
}
