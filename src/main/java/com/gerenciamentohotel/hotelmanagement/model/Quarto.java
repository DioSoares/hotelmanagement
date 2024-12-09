package com.gerenciamentohotel.hotelmanagement.model;


import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Data
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String numero;

    @NotNull
    private String tipo;

    @NotNull
    private Double preco;

    @Column(columnDefinition = "boolean default true")
    private boolean disponivel;


    @ManyToOne
    @JoinColumn(name = "hotel_id, nullable = false")
    private Hotel hotel;

    @OneToMany(mappedBy = "quarto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas;


    public Quarto() {

    }

    public Quarto(String numero, String tipo, Double preco, Hotel hotel){
        this.numero = numero;
        this.tipo = tipo;
        this.preco = preco;
        this.hotel = hotel;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
