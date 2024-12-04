package com.gerenciamentohotel.hotelmanagement.service;

import com.gerenciamentohotel.hotelmanagement.model.Hotel;
import com.gerenciamentohotel.hotelmanagement.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    private HotelServiceImpl(HotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Hotel> listarTodos() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel buscarPorId(Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Hotel não encontrado"));
    }

    @Override
    public Hotel salvar(Hotel hotel){
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel atualizar(Long id, Hotel hotelAtualizado){
        Hotel hotel = buscarPorId(id);
        hotel.setNome(hotelAtualizado.getNome());
        hotel.setEndereco(hotelAtualizado.getEndereco());
        hotel.setTelefone(hotelAtualizado.getTelefone());
        return hotelRepository.save(hotel);
    }

    @Override
    public void deletar(Long id) {
        Hotel hotel = buscarPorId(id);
        hotelRepository.delete(hotel);
    }
}
