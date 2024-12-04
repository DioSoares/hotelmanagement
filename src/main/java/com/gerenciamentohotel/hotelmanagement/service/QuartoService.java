package com.gerenciamentohotel.hotelmanagement.service;

import com.gerenciamentohotel.hotelmanagement.model.Quarto;

import java.util.List;

public interface QuartoService {
    List<Quarto> listarTodos();
    Quarto buscarPorId(Long id);
    Quarto salvar (Quarto quarto);
    Quarto atualizar(Long id, Quarto quarto);
    void deletar(Long id);
}
