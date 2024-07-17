package com.ntconsult.hotel.application.core.domain;

import java.time.LocalDate;
import java.util.Date;

public class HotelFiltro {

    private String destino;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private Integer qtdQuarto;
    private Integer qtdHospedes;
    private double preco;
    private String comodidade;
    private Integer avaliacao;

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getComodidade() {
        return comodidade;
    }

    public void setComodidade(String comodidade) {
        this.comodidade = comodidade;
    }

    public Integer getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Integer avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public Integer getQtdQuarto() {
        return qtdQuarto;
    }

    public void setQtdQuarto(Integer qtdQuarto) {
        this.qtdQuarto = qtdQuarto;
    }

    public Integer getQtdHospedes() {
        return qtdHospedes;
    }

    public void setQtdHospedes(Integer qtdHospedes) {
        this.qtdHospedes = qtdHospedes;
    }
}
