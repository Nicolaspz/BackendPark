package com.park.service;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.park.domain.Entrada_Saida;
import com.park.domain.Reserva;
import com.park.domain.Vaga;
import com.park.repository.Entrada_Saida_Repository;
import com.park.repository.ReservaRepository;
import com.park.repository.VagaRespository;

@Service
public class EntradaSaidaService {

    @Autowired
    private Entrada_Saida_Repository entradaSaidaRepository;

    @Autowired
    private VagaRespository vagaRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Entrada_Saida> getAllEntradas() {
        return entradaSaidaRepository.findEntradas();
    }

    public Entrada_Saida registrarEntrada(String placa) {
        // Verificar se a placa está associada a uma reserva
        Optional<Reserva> reservaOpt = reservaRepository.findByVeiculo(placa);
        Vaga vaga;

        if (reservaOpt.isPresent()) {
            // Se a reserva existir, usar a vaga da reserva
            Reserva reserva = reservaOpt.get();
            vaga = reserva.getVaga();
        } else {
            // Se a reserva não existir, procurar uma vaga disponível
            Optional<Vaga> vagaOpt = vagaRepository.findFirstByOucupadoIsFalseAndPrevilegioIsFalseAndReservadoIsFalse();
            if (vagaOpt.isEmpty()) {
                throw new RuntimeException("Não há vagas disponíveis.");
            }
            vaga = vagaOpt.get();
        }

        // Marcar a vaga como ocupada
        vaga.setOucupado(true);
        vagaRepository.save(vaga);

        // Registrar a entrada
        Entrada_Saida entradaSaida = new Entrada_Saida(placa, LocalDateTime.now(), false, vaga);
        return entradaSaidaRepository.save(entradaSaida);
    }

    public Entrada_Saida registrarSaida(Integer id) {
        Optional<Entrada_Saida> entradaSaidaOpt = entradaSaidaRepository.findById(id);
        if (entradaSaidaOpt.isPresent()) {
            Entrada_Saida entradaSaida = entradaSaidaOpt.get();
            entradaSaida.setTempo_saida(LocalDateTime.now());
            entradaSaida.setStatus(true); // saiu

            // Marcar a vaga como disponível novamente
            Vaga vaga = entradaSaida.getVaga();
            vaga.setOucupado(false);
            vaga.setReservado(false);
            vagaRepository.save(vaga);

            return entradaSaidaRepository.save(entradaSaida);
        } else {
            throw new RuntimeException("Registro de entrada não encontrado para o ID: " + id);
        }
    }

    
    public long calcularDuracao(Entrada_Saida entradaSaida) {
        if (entradaSaida.getTempo_saida() != null) {
            Duration duracao = Duration.between(entradaSaida.getTempo_entrada(), entradaSaida.getTempo_saida());
            return duracao.toMinutes();
        } else {
            throw new RuntimeException("Tempo de saída não registrado para o ID: " + entradaSaida.getId());
        }
    }

    public double calcularPagamento(Entrada_Saida entradaSaida, double taxaPorHora) {
        long duracaoMinutos = calcularDuracao(entradaSaida);
        double duracaoHoras = duracaoMinutos / 60.0;
        return duracaoHoras * taxaPorHora;
    }
}
