package com.park;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.park.domain.Entrada_Saida;
import com.park.domain.Ocorrencia;
import com.park.domain.Role;
import com.park.domain.User;
import com.park.domain.Vaga;
import com.park.repository.OcorrenciaRepository;
import com.park.repository.UserRepository;
import com.park.repository.VagaRespository;
import com.park.service.EntradaSaidaService;

@SpringBootApplication
public class ParkApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OcorrenciaRepository ocorrenciaRepo;
	@Autowired
	private VagaRespository vagaRepository;
	@Autowired
    private EntradaSaidaService entradaSaidaService;
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(ParkApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		User user = new User(null,"Nicolas","949714096","12345",Role.ADMIN);
		Ocorrencia ocorrencia = new Ocorrencia(null, "XS-C45-LA", "Bateu", user);
		Vaga vaga = new Vaga(null, "V-2", false, false);
		Vaga vaga1 = new Vaga(null, "V-1", false, true);
		Vaga vaga2 = new Vaga(null, "V-3", false, false);
		Vaga vaga3 = new Vaga(null, "V-4", true, false);
		Vaga vaga4 = new Vaga(null, "V-5", false, false);
		
		//Entrada_Saida entradaSaida = new Entrada_Saida(null, "X-2R-LD", , null, false, vaga4)
		
		this.userRepository.saveAll(Arrays.asList(user));
		this.ocorrenciaRepo.saveAll(Arrays.asList(ocorrencia));
		this.vagaRepository.saveAll(Arrays.asList(vaga,vaga1,vaga3,vaga4,vaga2));
		
		
		Entrada_Saida entradaSaida = entradaSaidaService.registrarEntrada("ABC-1234");
		//Entrada_Saida entradaSaida1 = entradaSaidaService.registrarEntrada(null)
        System.out.println("Entrada registrada: " + entradaSaida);
        //System.out.println("Entrada registrada: " + entradaSaida1);

        // Simular uma espera de 1 minuto
        Thread.sleep(60000);

        // Registrar a saída
       Entrada_Saida saida = entradaSaidaService.registrarSaida(entradaSaida.getId());
        System.out.println("Saída registrada: " + saida);

        //Calcular a duração
        long duracao = entradaSaidaService.calcularDuracao(saida);
        System.out.println("Duração em minutos: " + duracao);

        // Calcular o pagamento
        double taxaPorMinuto = 0.05; // exemplo de taxa por minuto
        double pagamento = entradaSaidaService.calcularPagamento(saida, taxaPorMinuto);
        System.out.println("Valor a ser pago: " + pagamento);
        //System.out.println("Entrada sem saida: " + entradaSaida.getId());
        
        
        
    }
	

}
