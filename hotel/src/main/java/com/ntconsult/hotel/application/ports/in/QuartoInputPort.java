package com.ntconsult.hotel.application.ports.in;

import com.ntconsult.hotel.application.core.domain.Cliente;
import com.ntconsult.hotel.application.core.domain.Hotel;
import com.ntconsult.hotel.application.core.domain.Quarto;

import java.util.Optional;

public interface QuartoInputPort {

    void update(Quarto quarto);
    void insert(Quarto quarto);
    void delete(Quarto quarto);
    Optional<Quarto> find(Long id);
    Optional<Quarto> findIdAndHotel(Long id, Hotel hotel);

}
