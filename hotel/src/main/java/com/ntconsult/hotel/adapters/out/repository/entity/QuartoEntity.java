package com.ntconsult.hotel.adapters.out.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "Quarto")
public class QuartoEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", nullable = false)
    private HotelEntity hotel;

    @OneToMany(mappedBy = "quarto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ReservaEntity> reservas;

    private double preco;
    private String descricao;
    private String comodidade;
    private Integer hospedes;

    public List<ReservaEntity> getReservas() {
        return reservas;
    }

    public void setReservas(List<ReservaEntity> reservas) {
        this.reservas = reservas;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HotelEntity getHotel() {
        return hotel;
    }

    public void setHotel(HotelEntity hotel) {
        this.hotel = hotel;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getComodidade() {
        return comodidade;
    }

    public void setComodidade(String comodidade) {
        this.comodidade = comodidade;
    }

    public Integer getHospedes() {
        return hospedes;
    }

    public void setHospedes(Integer hospedes) {
        this.hospedes = hospedes;
    }

}
