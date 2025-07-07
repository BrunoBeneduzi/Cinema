package com.projetoCinema.cinema.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoCinema.cinema.dto.AtoresRetornoDTO;
import com.projetoCinema.cinema.model.Atores;
import com.projetoCinema.cinema.repository.AtoresRepository;

@Service
public class ListagemAtores {
	@Autowired
	private AtoresRepository repository;
	
	
	
	public List<AtoresRetornoDTO> retornaAtores(Long id, String nomeCompleto,String nacionalidade) {
		
		
		if(id != null) {
			List<Atores> atores= (List<Atores>) repository.findById(id).get();
			
			return atores.stream().map(d -> new AtoresRetornoDTO(d.getId(), d.getNomeCompleto(), d.getDataDeNascimento(), d.getQtdPremios(), d.getNacionalidade())).collect(Collectors.toList());
			
		}
		if(nomeCompleto != null) {
			List<Atores> atores= repository.buscarAtoresPorNome(nomeCompleto.trim().toUpperCase());
			
			System.out.println(atores);
			return atores.stream().map(d -> new AtoresRetornoDTO(d.getId(), d.getNomeCompleto(), d.getDataDeNascimento(), d.getQtdPremios(), d.getNacionalidade())).collect(Collectors.toList());
		}
		if(nacionalidade != null) {
			List<Atores> atores = repository.findByNacionalidade(nacionalidade.trim().toUpperCase());
			
			return atores.stream().map(d -> new AtoresRetornoDTO(d.getId(), d.getNomeCompleto(), d.getDataDeNascimento(), d.getQtdPremios(), d.getNacionalidade())).collect(Collectors.toList());
		}
		
		return null;
		
	}
}