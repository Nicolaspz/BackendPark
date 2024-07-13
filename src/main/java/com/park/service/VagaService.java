package com.park.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.park.domain.Vaga;
import com.park.repository.VagaRespository;


@Service
public class VagaService {

    @Autowired
    private VagaRespository vagaRepository;

    public List<Vaga> findAll() {
        return vagaRepository.findAll();
    }

    public Optional<Vaga> findById(Integer id) {
        return vagaRepository.findById(id);
    }

    public Vaga save(Vaga vaga) {
        return vagaRepository.save(vaga);
    }

    public void deleteById(Integer id) {
        vagaRepository.deleteById(id);
    }

    public List<Vaga> findVagasLivres() {
        return vagaRepository.findVagasLivres();
    }
}