package com.gerenciamentohotel.hotelmanagement.controller;

import com.gerenciamentohotel.hotelmanagement.model.Hotel;
import com.gerenciamentohotel.hotelmanagement.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hoteis")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService){
        this.hotelService = hotelService;
    }

    @GetMapping
    public List<Hotel> listarTodos() {
        return hotelService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(hotelService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Hotel> salvar(@RequestBody Hotel hotel) {
        return ResponseEntity.ok(hotelService.salvar(hotel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        hotelService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
