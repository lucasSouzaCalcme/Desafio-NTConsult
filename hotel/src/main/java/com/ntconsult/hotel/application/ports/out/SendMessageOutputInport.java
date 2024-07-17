package com.ntconsult.hotel.application.ports.out;

import com.ntconsult.hotel.adapters.in.consumer.response.CustomerMessage;

public interface SendMessageOutputInport {

    void send(CustomerMessage msg);

}
