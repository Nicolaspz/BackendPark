package com.park.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.park.domain.Ocorrencia;
import com.park.service.OcorrenciaService;
import com.park.tdo.ocorrenciaDTO;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {

    @Autowired
    private OcorrenciaService ocorrenciaService;

    @GetMapping
    public ResponseEntity<List<ocorrenciaDTO>> findAll() {
        List<Ocorrencia> ocorrencias = ocorrenciaService.getAll();
        List<ocorrenciaDTO> ocorrenciaDTOs = ocorrencias.stream()
                                                        .map(this::convertToResponseOcorrencia)
                                                        .collect(Collectors.toList());
        return ResponseEntity.ok(ocorrenciaDTOs);
    }
    
    
  private ocorrenciaDTO convertToResponseOcorrencia(Ocorrencia ocorrencia) {
        return new ocorrenciaDTO(ocorrencia.getId(), ocorrencia.getPlaca(), ocorrencia.getDescricao());
    }
}
