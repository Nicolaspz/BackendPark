package com.park.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.park.domain.Ocorrencia;
import com.park.repository.OcorrenciaRepository;

@Service
public class OcorrenciaService {

	@Autowired
	private OcorrenciaRepository ocorrenciaRepository;
	
	
	public List<Ocorrencia> getAll(){
		return ocorrenciaRepository.findAll();
	}
	
	
}
