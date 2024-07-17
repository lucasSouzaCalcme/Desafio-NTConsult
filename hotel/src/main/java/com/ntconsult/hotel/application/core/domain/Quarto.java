package com.ntconsult.hotel.application.core.domain;

import com.ntconsult.hotel.adapters.out.repository.entity.HotelEntity;
import com.ntconsult.hotel.adapters.out.repository.entity.ReservaEntity;


import java.util.List;

public class Quarto {

    private Long id;
    private String comodidade;
    private String descricao;
    private double preco;
    private Integer hospedes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComodidade() {
        return comodidade;
    }

    public void setComodidade(String comodidade) {
        this.comodidade = comodidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Integer getHospedes() {
        return hospedes;
    }

    public void setHospedes(Integer hospedes) {
        this.hospedes = hospedes;
    }

}


