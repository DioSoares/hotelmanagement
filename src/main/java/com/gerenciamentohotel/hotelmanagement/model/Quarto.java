package com.gerenciamentohotel.hotelmanagement.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    private String tipo;

    private Double preco;

    @Column(columnDefinition = "booleam default true")
    private boolean disponivel;
}
