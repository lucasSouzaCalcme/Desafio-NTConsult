package com.ntconsult.hotel.adapters.in.controller;

import com.ntconsult.hotel.adapters.in.controller.mapper.ClienteMapper;
import com.ntconsult.hotel.adapters.in.controller.request.ClienteRequest;
import com.ntconsult.hotel.adapters.in.controller.response.ClienteResponse;
import com.ntconsult.hotel.application.ports.in.ClienteInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {
    @Autowired
    ClienteInputPort clienteInputPort;

    @Autowired
    ClienteMapper clienteMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody ClienteRequest clienteRequest){
        var cliente = clienteMapper.toCliente(clienteRequest);
        clienteInputPort.insert(cliente);
        return  ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> findByid(@PathVariable Long id){
        var cliente = clienteInputPort.find(id);
        var clienteResponse = clienteMapper.toClienteResponse(cliente.get());
        return  ResponseEntity.ok().body(clienteResponse);
    }


}
