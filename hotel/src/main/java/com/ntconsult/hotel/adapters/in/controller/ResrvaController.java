package com.ntconsult.hotel.adapters.in.controller;

import com.ntconsult.hotel.adapters.in.controller.mapper.ReservaMapper;
import com.ntconsult.hotel.adapters.in.controller.request.HotelRequest;
import com.ntconsult.hotel.adapters.in.controller.request.ReservaRequest;
import com.ntconsult.hotel.adapters.in.controller.response.HotelResponse;
import com.ntconsult.hotel.application.ports.in.ReservaInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reserva")
public class ResrvaController {

    @Autowired
    ReservaInputPort reservaInputPort;

    @Autowired
    ReservaMapper reservaMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> insert(@Valid @RequestBody ReservaRequest reservaRequest){
        var reserva = reservaMapper.toReserva(reservaRequest);
        reservaInputPort.insert(reserva);
        return  ResponseEntity.ok().build();
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<HotelResponse> findByid(@PathVariable Long id){
        var hotel = hotelInputPort.find(id);
        var hotelResponde = hotelMapper.toHotelResponde(hotel.get());
        return  ResponseEntity.ok().body(hotelResponde);
    }*/
}
