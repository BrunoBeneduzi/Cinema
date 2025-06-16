package com.projetoCinema.cinema.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoCinema.cinema.dto.FilmeAtualizaDTO;
import com.projetoCinema.cinema.model.Filme;
import com.projetoCinema.cinema.repository.FilmesRepository;

@Service
public class AtualizarFilme {
	@Autowired
	private FilmesRepository filmesRepository;
	
	public FilmeAtualizaDTO atualizaFilme(Long id, FilmeAtualizaDTO filmeDto) {
		Filme filme = this.filmesRepository.findById(id).get();
		
		
		if(filmeDto.nomeDiretor() != null) {
			filme.setNomeDiretor(filmeDto.nomeDiretor());
		}
		if(filmeDto.nomeFilme() != null) {
			 filme.setNomeFilme(filmeDto.nomeFilme());
		}
		if(filmeDto.nota() != null) {
			filme.setNota(filmeDto.nota());
		}
		if(filmeDto.dataDeLancamento() != null) {
			filme.setDataDeLancamento(filmeDto.dataDeLancamento());
		}
		
		this.filmesRepository.save(filme);
		
		return filmeDto;
	}
}