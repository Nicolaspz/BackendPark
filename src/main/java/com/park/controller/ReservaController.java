package com.park.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.park.domain.Reserva;
import com.park.domain.Vaga;
import com.park.service.ReservaService;
import com.park.tdo.ReservaDTO;
import com.park.tdo.ResponseVaga;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public ResponseEntity<List<ReservaDTO>> findAll() {
        List<Reserva> reservas = reservaService.findAll();
        List<ReservaDTO> reservaDTOs = reservas.stream()
        										.map(this::convertToReservaDTO)
        										.collect(Collectors.toList());
        return ResponseEntity.ok(reservaDTOs);
    }
    
    
    
    
    private ReservaDTO convertToReservaDTO(Reserva reserva) {
        return new ReservaDTO(
            reserva.getId(),
            reserva.getStatus().name(),
            reserva.getStatusPagamento().name(),
            reserva.getUser().getId(),
            reserva.getDataInicio(),
            reserva.getDataTermino(),
            reserva.getVaga().getId(),
            reserva.getVeiculo(),
            reserva.getValor(),
            reserva.getMetodoPagamento()
        );
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> findById(@PathVariable Integer id) {
        Optional<Reserva> reserva = reservaService.findById(id);
        return reserva.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Reserva> create(@RequestBody Reserva reserva) {
    	  System.out.println("Recebido: " + reserva);
        try {
            Reserva savedReserva = reservaService.createReservaWithVaga(reserva);
            return ResponseEntity.ok(savedReserva);
        } catch (RuntimeException e) {
        	   e.printStackTrace();
            return ResponseEntity.status(400).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!reservaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        reservaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
