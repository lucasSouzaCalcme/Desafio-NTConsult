package com.ntconsult.hotel.adapters.in.controller.request;

import java.util.Date;

public class ReservaRequest {

    private Long id;
    private Integer hotelId;
    private Integer quartoId;
    private Integer clienteId;
    private Date checkIn;
    private Date checkOut;
    private Integer diaria;

    public ReservaRequest(){};

    public ReservaRequest(Long id, Integer quarto, Integer clienteRequest,
                          Date checkIn, Date checkOut, Integer diaria,
                          Integer hotelId) {
        this.id = id;
        this.quartoId = quarto;
        this.clienteId = clienteRequest;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.diaria = diaria;
        this.hotelId = hotelId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuartoId() {
        return quartoId;
    }

    public void setQuartoId(Integer quartoId) {
        this.quartoId = quartoId;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Integer getDiaria() {
        return diaria;
    }

    public void setDiaria(Integer diaria) {
        this.diaria = diaria;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }
}
