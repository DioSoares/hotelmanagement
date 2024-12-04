package com.gerenciamentohotel.hotelmanagement.service;

import com.gerenciamentohotel.hotelmanagement.model.Reserva;

import java.util.List;

public interface ReservaService {
    List<Reserva> listarTodas();
    Reserva buscarPorId(Long id);
    Reserva salvar (Reserva reserva);
    Reserva atualizar(Long id, Reserva reserva);
    void deletar(Long id);
}
