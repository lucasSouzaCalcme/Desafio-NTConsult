package com.ntconsult.hotel.application.core.domain;

import com.ntconsult.hotel.adapters.out.repository.entity.QuartoEntity;


import java.util.List;

public class Hotel {
    private Long id;

    private String nome;

    private String endereco;

    private List<Quarto> quartos;
    private List<Integer> avaliacao;


    public Hotel(){}

    public Hotel(Long id, String nome, String endereco,List<Integer> avaliacao, List<Quarto> quartos) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.quartos = quartos;
        this.avaliacao = avaliacao;
    }

    public List<Integer> getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(List<Integer> avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public List<Quarto> getQuartos() {
        return quartos;
    }

    public void setQuartos(List<Quarto> quartos) {
        this.quartos = quartos;
    }
}
