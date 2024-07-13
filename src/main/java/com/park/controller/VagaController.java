package com.park.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

import com.park.domain.Vaga;
import com.park.service.VagaService;

@RestController
@RequestMapping("/vagas")
public class VagaController {

    @Autowired
    private VagaService vagaService;

    @GetMapping
    public ResponseEntity<List<Vaga>> getAllVagas() {
        List<Vaga> vagas = vagaService.findAll();
        return ResponseEntity.ok(vagas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vaga> getVagaById(@PathVariable Integer id) {
        Optional<Vaga> vaga = vagaService.findById(id);
        if (vaga.isPresent()) {
            return ResponseEntity.ok(vaga.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Vaga> createVaga(@RequestBody Vaga vaga) {
        Vaga savedVaga = vagaService.save(vaga);
        return ResponseEntity.ok(savedVaga);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVaga(@PathVariable Integer id) {
        vagaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/livres")
    public ResponseEntity<List<Vaga>> getVagasLivres() {
        List<Vaga> vagasLivres = vagaService.findVagasLivres();
        return ResponseEntity.ok(vagasLivres);
    }
}