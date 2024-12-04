package com.gerenciamentohotel.hotelmanagement.service;

import com.gerenciamentohotel.hotelmanagement.model.Quarto;
import com.gerenciamentohotel.hotelmanagement.model.Reserva;
import com.gerenciamentohotel.hotelmanagement.repository.QuartoRepository;
import com.gerenciamentohotel.hotelmanagement.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImpl implements  ReservaService{

    private final ReservaRepository reservaRepository;
    private final QuartoRepository quartoRepository;

    public ReservaServiceImpl(ReservaRepository reservaRepository, QuartoRepository quartoRepository){
        this.reservaRepository = reservaRepository;
        this.quartoRepository = quartoRepository;
    }

    @Override
    public List<Reserva> listarTodas() {
        return reservaRepository.findAll();
    }

    @Override
    public Reserva buscarPorId(Long id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada!"));
    }

    @Override
    public Reserva salvar(Reserva reserva) {

        Quarto quarto = quartoRepository.findById(reserva.getQuarto().getId())
                .orElseThrow(() -> new RuntimeException("Quarto não encontrado!"));

        if (! quarto.isDisponivel()) {
            throw new RuntimeException("O quarto não está disponível para reserva!");
        }

        quarto.setDisponivel(false);
        quartoRepository.save(quarto);

        return reservaRepository.save(reserva);
    }

    @Override
    public Reserva atualizar (Long id, Reserva reservaAtualizada) {
        Reserva reserva = buscarPorId(id);

        reserva.setCheckin(reservaAtualizada.getCheckin());
        reserva.setCheckout(reservaAtualizada.getCheckout());
        reserva.setNomeCliente(reservaAtualizada.getNomeCliente());
        reserva.setContatoCliente(reservaAtualizada.getContatoCliente());

        if(!reserva.getQuarto().getId().equals(reservaAtualizada.getQuarto().getId())) {
            Quarto quartoAtual = quartoRepository.findById(reservaAtualizada.getQuarto().getId())
                    .orElseThrow(() -> new RuntimeException("Quarto não encontrado!"));

            if(! quartoAtual.isDisponivel()) {
                throw new RuntimeException("O novo quarto não está disponível para reserva!");
            }

            Quarto quartoAntigo = reserva.getQuarto();
            quartoAntigo.setDisponivel(true);
            quartoAntigo.setDisponivel(false);

            quartoRepository.save(quartoAntigo);
            quartoRepository.save(quartoAtual);

            reserva.setQuarto(quartoAtual);
        }

        return reservaRepository.save(reserva);
    }

    @Override
    public void deletar(Long id) {
        Reserva reserva = buscarPorId(id);

        Quarto quarto = reserva.getQuarto();
        quarto.setDisponivel(true);
        quartoRepository.save(quarto);

        reservaRepository.delete(reserva);
    }
}
