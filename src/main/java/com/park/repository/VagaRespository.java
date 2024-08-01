package com.park.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.park.domain.Vaga;

@Repository
public interface VagaRespository extends JpaRepository<Vaga, Integer> {
	
	@Query("SELECT v FROM Vaga v WHERE v.oucupado = false")
    List<Vaga> findVagasLivres();
	
	 Optional<Vaga> findByOucupado(boolean status);
	 
	 Optional<Vaga> findFirstByOucupadoIsFalseAndPrevilegioIsFalseAndReservadoIsFalse();

}
