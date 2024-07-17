package com.ntconsult.hotel.adapters.in.consumer.response;

public class CustomerMessage {
    private String cdReserva;

    public CustomerMessage(){}

    public CustomerMessage(String cdReserva) {
        this.cdReserva = cdReserva;
    }

    public String getCdReserva() {
        return cdReserva;
    }

    public void setCdReserva(String cdReserva) {
        this.cdReserva = cdReserva;
    }
}
