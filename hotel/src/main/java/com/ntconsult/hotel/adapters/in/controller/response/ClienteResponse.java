package com.ntconsult.hotel.adapters.in.controller.response;

public class ClienteResponse {


    private String name;

    private String endereco;

    private String cpf;

    public ClienteResponse() {}

    public ClienteResponse(String name, String endereco, String cpf) {
        this.name = name;
        this.endereco = endereco;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
