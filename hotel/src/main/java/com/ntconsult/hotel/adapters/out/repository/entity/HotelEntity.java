package com.ntconsult.hotel.adapters.out.repository.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Hotel")
public class HotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String endereco;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<QuartoEntity> quartos;

    @ElementCollection
    private List<Integer> avaliacao;

    public List<Integer> getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(List<Integer> avaliacao) {
        this.avaliacao = avaliacao;
    }

    // Getters e setters

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

    public List<QuartoEntity> getQuartos() {
        return quartos;
    }

    public void setQuartos(List<QuartoEntity> quartos) {
        this.quartos = quartos;
        if (quartos != null) {
            for (QuartoEntity quarto : quartos) {
                quarto.setHotel(this);
            }
        }
    }
}
