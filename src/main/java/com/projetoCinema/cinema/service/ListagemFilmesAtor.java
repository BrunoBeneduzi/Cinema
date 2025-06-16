package com.projetoCinema.cinema.service;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoCinema.cinema.dto.AtoresRetornoDTO;
import com.projetoCinema.cinema.dto.FilmeRetornoDTO;
import com.projetoCinema.cinema.model.Filme;
import com.projetoCinema.cinema.repository.FilmesRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListagemFilmesAtor {
	@Autowired
	private FilmesRepository filmesRepository;
	
	public List<FilmeRetornoDTO> retornaFilmeAtor(String nomeFilme, String nomeDiretor, Long id, Double nota) {
		List<Filme> filmeLista = null;
		
		if(nomeFilme != null) {
			filmeLista = new ArrayList<>(this.filmesRepository.buscarFilmesComAtoresPorNomeDeFilme(nomeFilme.toUpperCase().trim()));
			
			return filmeLista.stream().map(f -> new FilmeRetornoDTO(
					f.getId(), 
					f.getNomeFilme(),  
					f.getNota(), 
					f.getNomeDiretor(),
					f.getDataDeLancamento(), 
					f.getAtores().stream().map(a -> new AtoresRetornoDTO(
							a.getId(),
							a.getNomeCompleto(),
							a.getDataDeNascimento(),
							a.getQtdPremios(),
							a.getNacionalidade())).collect(Collectors.toList())
					)).collect(Collectors.toList());
		}
		if(nomeDiretor != null) {
			filmeLista = new ArrayList<>(this.filmesRepository.buscarFilmesComAtoresPorNomeDoDiretor(nomeDiretor.toUpperCase().trim()));
			
			return filmeLista.stream().map(f -> new FilmeRetornoDTO(
					f.getId(), 
					f.getNomeFilme(),  
					f.getNota(), 
					f.getNomeDiretor(),
					f.getDataDeLancamento(), 
					f.getAtores().stream().map(a -> new AtoresRetornoDTO(
							a.getId(),
							a.getNomeCompleto(),
							a.getDataDeNascimento(),
							a.getQtdPremios(),
							a.getNacionalidade())).collect(Collectors.toList())
					)).collect(Collectors.toList());
		}
		
		if(id != null) {
			filmeLista = new ArrayList<>(this.filmesRepository.buscarFilmesComAtoresPorIdDeFilme(id));
			
			return filmeLista.stream().map(f -> new FilmeRetornoDTO(
					f.getId(), 
					f.getNomeFilme(),  
					f.getNota(), 
					f.getNomeDiretor(),
					f.getDataDeLancamento(), 
					f.getAtores().stream().map(a -> new AtoresRetornoDTO(
							a.getId(),
							a.getNomeCompleto(),
							a.getDataDeNascimento(),
							a.getQtdPremios(),
							a.getNacionalidade())).collect(Collectors.toList())
					)).collect(Collectors.toList());
		}
		
		if(nota != null) {
			filmeLista = new ArrayList<>(this.filmesRepository.buscarFilmesComAtoresPorNotaMinima(nota));
			
			return filmeLista.stream().map(f -> new FilmeRetornoDTO(
					f.getId(), 
					f.getNomeFilme(),  
					f.getNota(), 
					f.getNomeDiretor(),
					f.getDataDeLancamento(), 
					f.getAtores().stream().map(a -> new AtoresRetornoDTO(
							a.getId(),
							a.getNomeCompleto(),
							a.getDataDeNascimento(),
							a.getQtdPremios(),
							a.getNacionalidade())).collect(Collectors.toList())
					)).collect(Collectors.toList());
		}
		
		return null;
	}
}