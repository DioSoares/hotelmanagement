package com.gerenciamentohotel.hotelmanagement.service;

import com.gerenciamentohotel.hotelmanagement.model.Quarto;
import com.gerenciamentohotel.hotelmanagement.repository.QuartoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartoServiceImpl implements QuartoService {
    private final QuartoRepository quartoRepository;

    public QuartoServiceImpl(QuartoRepository quartoRepository){
        this.quartoRepository = quartoRepository;
    }

    @Override
    public List<Quarto> listarTodos() {
        return quartoRepository.findAll();
    }

    @Override
    public Quarto buscarPorId(Long id) {
        return quartoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quarto não encontrado!"));
    }

    @Override
    public Quarto salvar(Quarto quarto){
        return quartoRepository.save(quarto);
    }

    @Override
    public Quarto atualizar(Long id, Quarto quartoAtualizado) {
        Quarto quarto = buscarPorId(id);
        quarto.setNumero(quartoAtualizado.getNumero());
        quarto.setTipo(quartoAtualizado.getTipo());
        quarto.setPreco(quartoAtualizado.getPreco());
        quarto.setDisponivel(quartoAtualizado.isDisponivel());
        return quartoRepository.save(quarto);
    }

    @Override
    public void deletar(Long id){
        Quarto quarto = buscarPorId(id);
        quartoRepository.delete(quarto);
    }
}
