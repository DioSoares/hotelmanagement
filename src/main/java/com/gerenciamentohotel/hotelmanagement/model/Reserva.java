package com.gerenciamentohotel.hotelmanagement.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate checkin;
    private LocalDate checkout;

    @ManyToOne
    @JoinColumn(name = "quarto_id")
    private Quarto quarto;

    private String nomeCliente;
    private String contatoCliente;
}
