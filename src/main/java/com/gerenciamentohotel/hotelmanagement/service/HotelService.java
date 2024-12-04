package com.gerenciamentohotel.hotelmanagement.service;

import com.gerenciamentohotel.hotelmanagement.model.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> listarTodos();
    Hotel buscarPorId(Long id);
    Hotel salvar(Hotel hotel);
    Hotel atualizar(Long id, Hotel hotel);
    void deletar(Long id);
}
