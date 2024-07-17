package com.ntconsult.hotel.adapters.in.controller.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ntconsult.hotel.adapters.in.controller.request.QuartoRequest;
import com.ntconsult.hotel.application.core.domain.Quarto;

import java.util.List;

public class HotelResponse {

    private String nome;
    private String endereco;
    private List<QuartoRequest> quartos;
    @JsonIgnore
    private double avaliacao;

    // Getters e setters

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<QuartoRequest> getQuartos() {
        return quartos;
    }

    public void setQuartos(List<QuartoRequest> quartos) {
        this.quartos = quartos;
    }
}
