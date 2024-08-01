package com.park.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.park.domain.Reserva;
import com.park.domain.Vaga;
import com.park.repository.ReservaRepository;
import com.park.repository.VagaRespository;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private VagaRespository vagaRepository;

    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    public Optional<Reserva> findById(Integer id) {
        return reservaRepository.findById(id);
    }

    public Reserva save(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public void deleteById(Integer id) {
        reservaRepository.deleteById(id);
    }

    public Optional<Vaga> findAvailableVaga() {
        return vagaRepository.findFirstByOucupadoIsFalseAndPrevilegioIsFalseAndReservadoIsFalse();
    }

    public void updateVagaStatus(Vaga vaga, boolean isAvailable) {
        vaga.setReservado(!isAvailable); // Define 'reservado' como true se 'isAvailable' for false e vice-versa
        vagaRepository.save(vaga); // Salvar as mudanças no banco de dados
    }

    public Reserva createReservaWithVaga(Reserva reserva) {
        Optional<Vaga> availableVaga = findAvailableVaga();
        if (availableVaga.isPresent()) {
            Vaga vaga = availableVaga.get();
            reserva.setVaga(vaga);
            updateVagaStatus(vaga, false);
            return save(reserva);
        } else {
            throw new RuntimeException("No available parking spots.");
        }
    }
}
