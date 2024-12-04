package com.gerenciamentohotel.hotelmanagement.controller;

import com.gerenciamentohotel.hotelmanagement.model.Quarto;
import com.gerenciamentohotel.hotelmanagement.service.QuartoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quartos")
public class QuartoController {

    private final QuartoService quartoService;

    public QuartoController(QuartoService quartoService) {
        this.quartoService = quartoService;
    }

    @GetMapping
    public List<Quarto> listarTodos() {
        return quartoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quarto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(quartoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Quarto> salvar(@RequestBody Quarto quarto) {
        return ResponseEntity.ok(quartoService.salvar(quarto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Quarto> atualizar(@PathVariable Long id, @RequestBody Quarto quarto) {
        return ResponseEntity.ok(quartoService.atualizar(id, quarto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id)  {
        quartoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
