package com.ntconsult.hotel.application.ports.in;

import com.ntconsult.hotel.application.core.domain.Cliente;

import java.util.Optional;

public interface ClienteInputPort {

    void update(Cliente cliente);
    void insert(Cliente cliente);
    void delete(Cliente cliente);
    Optional<Cliente> find(Long id);


}
