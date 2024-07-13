package com.park.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.park.domain.Vaga;

@Repository
public interface VagaRespository extends JpaRepository<Vaga, Integer> {
	
	@Query("SELECT v FROM Vaga v WHERE v.status = true")
    List<Vaga> findVagasLivres();

}
