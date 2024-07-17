package com.ntconsult.hotel.application.ports.out;

import com.ntconsult.hotel.application.core.domain.Cliente;

import java.util.Optional;

public interface ClienteOutputPort {

    void update(Cliente cliente);
    void insert(Cliente cliente);
    void delete(Cliente cliente);
    Optional<Cliente> find(Long id);
}
