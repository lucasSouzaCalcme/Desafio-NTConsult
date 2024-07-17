package com.ntconsult.hotel.application.core.usecase;

import com.ntconsult.hotel.application.core.domain.Cliente;
import com.ntconsult.hotel.application.ports.in.ClienteInputPort;
import com.ntconsult.hotel.application.ports.out.ClienteOutputPort;

import java.util.Optional;

public class ClienteUseCase implements ClienteInputPort {

    ClienteOutputPort clienteOutputPort;

    public ClienteUseCase(ClienteOutputPort clienteOutputPort){
        this.clienteOutputPort = clienteOutputPort;
    }

    @Override
    public void update(Cliente cliente) {

    }

    @Override
    public void insert(Cliente cliente) {
        clienteOutputPort.insert(cliente);

    }

    @Override
    public void delete(Cliente cliente) {

    }

    @Override
    public Optional<Cliente> find(Long id) {
        return Optional.ofNullable(clienteOutputPort.find(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado")));
    }
}
