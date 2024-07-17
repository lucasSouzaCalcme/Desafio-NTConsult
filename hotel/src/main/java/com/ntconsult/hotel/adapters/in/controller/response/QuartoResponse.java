package com.ntconsult.hotel.adapters.in.controller.response;

import java.util.List;

public class QuartoResponse {

    private String comodidade;
    private String descricao;
    private double preco;
    private Integer hospedes;

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
