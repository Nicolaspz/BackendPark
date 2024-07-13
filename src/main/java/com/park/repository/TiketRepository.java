package com.park.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.park.domain.Ticket;

@Repository
public interface TiketRepository extends JpaRepository<Ticket, Integer> {

}
