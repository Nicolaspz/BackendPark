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
import java.util.stream.Collectors;

import com.park.domain.Vaga;
import com.park.service.VagaService;
import com.park.tdo.ResponseVaga;

@RestController
@RequestMapping("/vagas")
public class VagaController {

    @Autowired
    private VagaService vagaService;

    @GetMapping
    public ResponseEntity<List<ResponseVaga>> getAllVagas() {
        List<Vaga> vagas = vagaService.findAll();
        List<ResponseVaga> responseVagas = vagas.stream()
                                                 .map(this::convertToResponseVaga)
                                                 .collect(Collectors.toList());
        return ResponseEntity.ok(responseVagas);
    }
    
    private ResponseVaga convertToResponseVaga(Vaga vaga) {
        return new ResponseVaga(vaga.getId(), vaga.getCodeVaga(), vaga.isOucupado(), vaga.isPrevilegio(), vaga.isReservado());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseVaga> getVagaById(@PathVariable Integer id) {
        Optional<Vaga> vaga = vagaService.findById(id);
        if (vaga.isPresent()) {
            ResponseVaga responseVaga = convertToResponseVaga(vaga.get());
            return ResponseEntity.ok(responseVaga);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

   

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVaga(@PathVariable Integer id) {
        vagaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/livres")
    public ResponseEntity<List<ResponseVaga>> getVagasLivres() {
        List<Vaga> vagasLivres = vagaService.findVagasLivres();
        List<ResponseVaga> responseVagas = vagasLivres.stream()
                                                      .map(this::convertToResponseVaga)
                                                      .collect(Collectors.toList());
        return ResponseEntity.ok(responseVagas);
    }
    
    @PostMapping
    public ResponseEntity<Vaga> createVaga(@RequestBody Vaga vaga) {
        Vaga savedVaga = vagaService.save(vaga);
        return ResponseEntity.ok(savedVaga);
    }
}