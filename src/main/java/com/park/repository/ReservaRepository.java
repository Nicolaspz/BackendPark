package com.park.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.park.domain.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva,Integer> {

	Optional<Reserva> findByVeiculo(String veiculo);
}
