package com.ntconsult.hotel.adapters.in.consumer;

import com.ntconsult.hotel.adapters.in.consumer.response.CustomerMessage;
import com.ntconsult.hotel.adapters.in.controller.mapper.ReservaMapper;
import com.ntconsult.hotel.adapters.out.repository.entity.ReservaEntity;
import com.ntconsult.hotel.application.ports.in.ReservaInputPort;
import com.ntconsult.hotel.application.ports.out.SendMessageOutputInport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerMessager {

    @Autowired
    ReservaInputPort reservaInputPort;

    @Autowired
    ReservaMapper reservaMapper;

    @KafkaListener(topics = "tp-reserva", groupId = "reserva")
    public void receive(CustomerMessage customerMessage){
        reservaInputPort.update((long) Integer.parseInt(customerMessage.getCdReserva()));
    }
}
