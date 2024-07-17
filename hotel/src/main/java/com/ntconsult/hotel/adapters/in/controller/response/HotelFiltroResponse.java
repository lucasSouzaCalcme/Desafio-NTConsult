package com.ntconsult.hotel.adapters.in.controller.response;

public class HotelFiltroResponse {

    private Long id;
    private String nome;
    private String endereco;
    private Long qtdQuartos;
    private Double avaliacao;

    public HotelFiltroResponse(){}
    public HotelFiltroResponse(Long id, String nome, String endereco, Long qtdQuartos, Double avaliacao) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.qtdQuartos = qtdQuartos;
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

    public Long getQtdQuartos() {
        return qtdQuartos;
    }

    public void setQtdQuartos(Long qtdQuartos) {
        this.qtdQuartos = qtdQuartos;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }
}
