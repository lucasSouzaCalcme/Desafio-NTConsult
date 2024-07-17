package com.ntconsult.hotel.adapters.out.repository.mapper;

import com.ntconsult.hotel.adapters.out.repository.entity.ClienteEntity;
import com.ntconsult.hotel.application.core.domain.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteEntityMapper {

    ClienteEntity toClienteEntity(Cliente cliente);

    Cliente toCliente(ClienteEntity clienteEntity);

}
