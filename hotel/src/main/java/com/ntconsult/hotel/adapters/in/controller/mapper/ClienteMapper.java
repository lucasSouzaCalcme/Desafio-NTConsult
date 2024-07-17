package com.ntconsult.hotel.adapters.in.controller.mapper;

import com.ntconsult.hotel.adapters.in.controller.request.ClienteRequest;
import com.ntconsult.hotel.adapters.in.controller.response.ClienteResponse;
import com.ntconsult.hotel.application.core.domain.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente toCliente(ClienteRequest clienteRequest);

    ClienteRequest toClienteRequest(Cliente cliente);

    ClienteResponse toClienteResponse(Cliente cliente);
}
