package com.ntconsult.hotel.adapters.in.controller;

import com.ntconsult.hotel.adapters.in.controller.mapper.HotelMapper;
import com.ntconsult.hotel.adapters.in.controller.request.ClienteRequest;
import com.ntconsult.hotel.adapters.in.controller.request.HotelRequest;
import com.ntconsult.hotel.adapters.in.controller.response.ClienteResponse;
import com.ntconsult.hotel.adapters.in.controller.response.HotelResponse;
import com.ntconsult.hotel.adapters.out.repository.entity.HotelEntity;
import com.ntconsult.hotel.application.core.domain.HotelFiltro;
import com.ntconsult.hotel.application.ports.in.HotelInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/hoteis")
public class HotelController {

    @Autowired
    HotelInputPort hotelInputPort;

    @Autowired
    HotelMapper hotelMapper;

   @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
           produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> insert(@Valid @RequestBody HotelRequest hotelRequest){
        var hotel = hotelMapper.toHotel(hotelRequest);
        hotelInputPort.insert(hotel);
        return  ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelResponse> findByid(@PathVariable Long id){
        var hotel = hotelInputPort.find(id);
        var hotelResponde = hotelMapper.toHotelResponde(hotel.get());
        return  ResponseEntity.ok().body(hotelResponde);
    }

    @PostMapping("/filtro")
    public ResponseEntity<List<HotelResponse>> findFiltro(@RequestBody HotelFiltro hotelFiltro){
        var hotel = hotelInputPort.findHotelFiltro(hotelFiltro);
        var hotelResponde = hotel.stream()
                .map(hotelMapper::toHotelResponde)
                .collect(Collectors.toList());
        return  ResponseEntity.ok().body(hotelResponde);
    }

    @PostMapping("/opcoes")
    public ResponseEntity<List<HotelResponse>> findOpcoes(@RequestBody HotelFiltro hotelFiltro){
        var hotel = hotelInputPort.findHotelFiltroOpcoes(hotelFiltro);
        var hotelResponde = hotel.stream()
                .map(hotelMapper::toHotelResponde)
                .collect(Collectors.toList());
        return  ResponseEntity.ok().body(hotelResponde);
    }
}
