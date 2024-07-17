package com.ntconsult.hotel.application.core.usecase;

import com.ntconsult.hotel.application.core.domain.Hotel;
import com.ntconsult.hotel.application.core.domain.Quarto;
import com.ntconsult.hotel.application.ports.in.QuartoInputPort;
import com.ntconsult.hotel.application.ports.out.QuartoOutputPort;

import java.util.Optional;

public class QuartoUseCase implements QuartoInputPort {

    private QuartoOutputPort quartoOutputPort;

    public QuartoUseCase(QuartoOutputPort quartoOutputPort)
    {
        this.quartoOutputPort = quartoOutputPort;
    }

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
    public Optional<Quarto> find(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Quarto> findIdAndHotel(Long id, Hotel hotel) {

        return Optional.empty();
    }
}
