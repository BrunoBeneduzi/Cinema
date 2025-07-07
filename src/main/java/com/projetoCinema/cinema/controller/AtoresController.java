package com.projetoCinema.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projetoCinema.cinema.dto.AtoresRetornoDTO;
import com.projetoCinema.cinema.service.ListagemAtores;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/ator")
@SecurityRequirement(name = "bearer-key")
public class AtoresController {
	@Autowired
	private ListagemAtores listagem;
	
	@GetMapping
	ResponseEntity retornaAtores(
			@RequestParam(required = false) Long id,
			@RequestParam(required = false) String nomeCompleto,
			@RequestParam(required = false) String nacionalidade){
		
		
		
		List<AtoresRetornoDTO> dto = listagem.retornaAtores(id, nomeCompleto, nacionalidade);
		
		if(dto == null || dto.isEmpty()) {
			System.out.println(dto);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado");
		}else {
			System.out.println(dto);
			return ResponseEntity.ok(dto);
		}
		
	}

}