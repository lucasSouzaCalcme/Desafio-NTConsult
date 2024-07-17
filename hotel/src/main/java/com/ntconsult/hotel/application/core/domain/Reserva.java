package com.ntconsult.hotel.application.core.domain;

import java.util.Date;

public class Reserva {

    private Long id;
    private Integer hotelId;
    private Integer quartoId;
    private Integer clienteId;
    private Date checkIn;
    private Date checkOut;
    private Integer diaria;
    private Quarto quarto;
    private Cliente clienteEntity;
    private Hotel hotel;
    private String status;
    private double total;

    public Reserva(){}
    public Reserva(Long id, Integer hotelId, Integer quartoId, Integer clienteId, Date checkIn, Date checkOut, Integer diaria, String status,double total) {
        this.id = id;
        this.hotelId = hotelId;
        this.quartoId = quartoId;
        this.clienteId = clienteId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.diaria = diaria;
        this.status = status;
        this.total = total;
    }

    public Reserva(Long id, Integer hotelId, Integer quartoId, Integer clienteId, Date checkIn, Date checkOut, Integer diaria, Quarto quarto, Cliente clienteEntity, String status,double total) {
        this.id = id;
        this.hotelId = hotelId;
        this.quartoId = quartoId;
        this.clienteId = clienteId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.diaria = diaria;
        this.quarto = quarto;
        this.clienteEntity = clienteEntity;
        this.status = status;
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Cliente getClienteEntity() {
        return clienteEntity;
    }

    public void setClienteEntity(Cliente clienteEntity) {
        this.clienteEntity = clienteEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
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
}
