package com.ntconsult.hotel.application.core.usecase;

import com.ntconsult.hotel.adapters.in.consumer.response.CustomerMessage;
import com.ntconsult.hotel.adapters.out.repository.entity.ReservaEntity;
import com.ntconsult.hotel.application.core.domain.Hotel;
import com.ntconsult.hotel.application.core.domain.Reserva;
import com.ntconsult.hotel.application.ports.in.ReservaInputPort;
import com.ntconsult.hotel.application.ports.out.*;

import java.util.Optional;

public class ReservaUseCase implements ReservaInputPort {

    private ReservaOutputPort reservaOutputPort;

    private HotelOutputPort hotelOutputPort;

    private ClienteOutputPort clienteOutputPort;

    private QuartoOutputPort quartoOutputPort;

    private SendMessageOutputInport sendMessageOutputInport;


    public ReservaUseCase(ReservaOutputPort reservaOutputPort,
                          HotelOutputPort hotelOutputPort,
                          ClienteOutputPort clienteOutputPort,
                          QuartoOutputPort quartoOutputPort,
                          SendMessageOutputInport sendMessageOutputInport
    )
    {
        this.reservaOutputPort = reservaOutputPort;
        this.hotelOutputPort = hotelOutputPort;
        this.clienteOutputPort = clienteOutputPort;
        this.quartoOutputPort = quartoOutputPort;
        this.sendMessageOutputInport = sendMessageOutputInport;
    }

    @Override
    public void update(Long id) {
        reservaOutputPort.update(id);
    }

    @Override
    public void insert(Reserva reserva) {
        CustomerMessage customerMessage = new CustomerMessage();
        var hotel = hotelOutputPort.find(reserva.getHotelId().longValue())
                .orElseThrow(() -> new RuntimeException("Nenhum hotel encontrado"));
        var quarto = quartoOutputPort.find(reserva.getQuartoId().longValue(), hotel)
                .orElseThrow(() -> new RuntimeException("Nenhum quarto encontrado"));
        var cliente = clienteOutputPort.find(reserva.getClienteId().longValue())
                .orElseThrow(() -> new RuntimeException("Nenhum cliente encontrado"));

        var reservaStatus = reservaOutputPort.buscaPorHoteleQuarto(hotel, quarto);
        checkReservaExistsAndThrow(reservaStatus);

        reserva.setQuarto(quarto);
        reserva.setClienteEntity(cliente);
        reserva.setHotel(hotel);
        reserva.setStatus("AGUADANDO_PAGAMENTO");
        reserva.setTotal(quarto.getPreco() * reserva.getDiaria());
        reservaOutputPort.insert(reserva);
        customerMessage.setCdReserva(reserva.getId().toString());
        sendMessageOutputInport.send(customerMessage);

    }

    @Override
    public void delete(Reserva reserva) {

    }

    @Override
    public ReservaEntity find(Long id) {
        return reservaOutputPort.find(id);
    }

    public void checkReservaExistsAndThrow(Optional<Reserva> reserva) {
        if (!reserva.isEmpty()) {
            throw new RuntimeException("Existe reserva para esse quarto ");
        }
    }
}


