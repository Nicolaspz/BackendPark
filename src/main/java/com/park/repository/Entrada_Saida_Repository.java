package com.park.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.park.domain.Entrada_Saida;


@Repository
public interface Entrada_Saida_Repository extends JpaRepository<Entrada_Saida, Integer> {
	
	@Query("SELECT v FROM Entrada_Saida v WHERE v.tempo_saida is null")
    List<Entrada_Saida> findEntradas();
	
}
