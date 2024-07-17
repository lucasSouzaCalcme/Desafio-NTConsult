package com.ntconsult.hotel.adapters.out;

import com.ntconsult.hotel.adapters.out.repository.ClienteRepository;
import com.ntconsult.hotel.adapters.out.repository.mapper.ClienteEntityMapper;
import com.ntconsult.hotel.application.core.domain.Cliente;
import com.ntconsult.hotel.application.ports.out.ClienteOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClienteAdapter implements ClienteOutputPort {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ClienteEntityMapper clienteMapper;

    @Override
    public void update(Cliente cliente) {
        var clienteEntity = clienteMapper.toClienteEntity(cliente);
        clienteRepository.save(clienteEntity);

    }

    @Override
    public void insert(Cliente cliente) {
        var clienteEntity = clienteMapper.toClienteEntity(cliente);
        clienteRepository.save(clienteEntity);
    }

    @Override
    public void delete(Cliente cliente) {
        var clienteEntity = clienteMapper.toClienteEntity(cliente);
        clienteRepository.delete(clienteEntity);
    }

    @Override
    public Optional<Cliente> find(Long id) {
        var clienteEntity = clienteRepository.findById(id);
        return clienteEntity.map(cliente -> clienteMapper.toCliente(cliente));
    }
}
