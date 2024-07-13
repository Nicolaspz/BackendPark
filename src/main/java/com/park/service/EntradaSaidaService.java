package com.park.service;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.park.domain.Entrada_Saida;
import com.park.domain.Vaga;
import com.park.repository.Entrada_Saida_Repository;
import com.park.repository.VagaRespository;


@Service
public class EntradaSaidaService {

	@Autowired
	private Entrada_Saida_Repository EntradaSaidaRepository;
	
	@Autowired
	private VagaRespository vagaRepository;
	
	
	public List<Entrada_Saida> getAllEntradas() {
		return EntradaSaidaRepository.findEntradas();
	}
	
	 public Entrada_Saida registrarEntrada(String placa) {
	        List<Vaga> vagasLivres = vagaRepository.findVagasLivres();
	        if (vagasLivres.isEmpty()) {
	            throw new RuntimeException("Não há vagas disponíveis.");
	        } else {
	            Vaga vaga = vagasLivres.get(0);
	            Entrada_Saida entradaSaida = new Entrada_Saida(placa,LocalDateTime.now(), false, vaga);
	            vaga.setStatus(false); // Marca a vaga como ocupada
	            vagaRepository.save(vaga); // Atualiza o status da vaga no banco de dados
	            
	            return EntradaSaidaRepository.save(entradaSaida);
	        }
	    }

	    public Entrada_Saida registrarSaida(Integer id) {
	        Optional<Entrada_Saida> entradaSaidaOpt = EntradaSaidaRepository.findById(id);
	        if (entradaSaidaOpt.isPresent()) {
	            Entrada_Saida entradaSaida = entradaSaidaOpt.get();
	            entradaSaida.setTempo_saida(LocalDateTime.now());
	            entradaSaida.setStatus(true);//saiu

	            // Marca a vaga como disponível novamente
	            Vaga vaga = entradaSaida.getVaga();
	            vaga.setStatus(true);
	            vagaRepository.save(vaga);

	            return EntradaSaidaRepository.save(entradaSaida);
	        } else {
	            throw new RuntimeException("Registro de entrada não encontrado para o ID: " + id);
	        }
	    }

	    public long calcularDuracao(Entrada_Saida entradaSaida) {
	        if (entradaSaida.getTempo_saida()!= null) {
	        	Duration duracao =  Duration.between(entradaSaida.getTempo_entrada(), entradaSaida.getTempo_saida());
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
