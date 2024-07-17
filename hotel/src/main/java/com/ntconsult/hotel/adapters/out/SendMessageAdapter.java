package com.ntconsult.hotel.adapters.out;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.ntconsult.hotel.adapters.in.consumer.response.CustomerMessage;
import com.ntconsult.hotel.application.ports.out.SendMessageOutputInport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendMessageAdapter implements SendMessageOutputInport {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    Gson gson = new Gson();


    @Override
    public void send(CustomerMessage msg) {
        kafkaTemplate.send("tp-reserva", gson.toJson(msg));
    }
}
