package com.park.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.park.domain.Ocorrencia;
import com.park.service.OcorrenciaService;

@RestController
@RequestMapping("/occorrencia")
public class OcorrenciaController {
	
	@Autowired
	private OcorrenciaService ocorrenciaService;
	
	
	@GetMapping
	public List<Ocorrencia> Lista(){
		return ocorrenciaService.getAll();
	}
	


}
