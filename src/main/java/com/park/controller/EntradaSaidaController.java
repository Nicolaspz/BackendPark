package com.park.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.park.domain.Entrada_Saida;
import com.park.domain.Vaga;
import com.park.service.EntradaSaidaService;

@RestController
@RequestMapping("/parking")
public class EntradaSaidaController {

    @Autowired
    private EntradaSaidaService entradaSaidaService;

    @PostMapping("/entrada")
    public ResponseEntity<Entrada_Saida> registrarEntrada(@RequestParam String placa) {
        try {
            Entrada_Saida entrada = entradaSaidaService.registrarEntrada(placa);
            return ResponseEntity.ok(entrada);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/saida/{id}")
    public ResponseEntity<Entrada_Saida> registrarSaida(@PathVariable Integer id) {
        try {
            Entrada_Saida saida = entradaSaidaService.registrarSaida(id);
            return ResponseEntity.ok(saida);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/duracao/{id}")
    public ResponseEntity<Long> calcularDuracao(@PathVariable Integer id) {
        try {
            Entrada_Saida entradaSaida = entradaSaidaService.registrarSaida(id);
            long duracao = entradaSaidaService.calcularDuracao(entradaSaida);
            return ResponseEntity.ok(duracao);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/pagamento/{id}")
    public ResponseEntity<Double> calcularPagamento(@PathVariable Integer id, @RequestParam double taxaPorHora) {
        try {
            Entrada_Saida entradaSaida = entradaSaidaService.registrarSaida(id);
            double pagamento = entradaSaidaService.calcularPagamento(entradaSaida, taxaPorHora);
            return ResponseEntity.ok(pagamento);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/entradas")
    public ResponseEntity<List<Entrada_Saida>> getAllVagas() {
        List<Entrada_Saida> entradas = entradaSaidaService.getAllEntradas();
        return ResponseEntity.ok(entradas);
    }
}