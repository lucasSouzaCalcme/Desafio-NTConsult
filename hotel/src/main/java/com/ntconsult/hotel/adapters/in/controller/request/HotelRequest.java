package com.ntconsult.hotel.adapters.in.controller.request;

import java.util.List;

public class HotelRequest {
    private String nome;
    private String endereco;
    private List<QuartoRequest> quartos;

    private List<Integer> avaliacao;

    // Getters e setters


    public List<Integer> getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(List<Integer> avaliacao) {
        this.avaliacao = avaliacao;
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
