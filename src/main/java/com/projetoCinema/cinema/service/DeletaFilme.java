package com.projetoCinema.cinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projetoCinema.cinema.model.Filme;
import com.projetoCinema.cinema.repository.FilmesRepository;

@Service
public class DeletaFilme {
	@Autowired
	private FilmesRepository filmesRepository;
	
	public Filme deletaFilme(Long id) {
		Filme filme = this.filmesRepository.findById(id).get();
		
		
		this.filmesRepository.delete(filme); 
		
		return filme;
		
	}
}