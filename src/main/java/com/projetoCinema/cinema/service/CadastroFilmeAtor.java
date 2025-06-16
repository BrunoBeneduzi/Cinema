package com.projetoCinema.cinema.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projetoCinema.cinema.dto.AtoresCadastroDTO;
import com.projetoCinema.cinema.dto.FilmeCadastroDTO;
import com.projetoCinema.cinema.model.Atores;
import com.projetoCinema.cinema.model.Filme;
import com.projetoCinema.cinema.repository.AtoresRepository;
import com.projetoCinema.cinema.repository.FilmesRepository;

@Service
public class CadastroFilmeAtor {
	@Autowired
	private FilmesRepository filmeRepository;
	@Autowired
	private AtoresRepository atoresRepository;
	
	public void cadastrarFilmeAutor(List<FilmeCadastroDTO> filmeDto) {//o json permite o cadastro de varios filmes ao mesmo tempo
		
		this.verificaSeFilmeExiste(filmeDto);
	}
	
	
	private void verificaSeFilmeExiste(List<FilmeCadastroDTO> filmeDto) {
		Filme filme = null;
		
		for(FilmeCadastroDTO listaDtoFilme : filmeDto) {//separa a lista de filmes em um filme só e seus atores
			
			if(this.filmeRepository.findByNomeFilme(listaDtoFilme.nomeFilme().toUpperCase()) != null) {
				
			}else {
				
				filme = new Filme(listaDtoFilme);
					
				filme.setAtores(this.verificaSeAtorExiste(listaDtoFilme));
				
				this.atoresRepository.saveAll(filme.getAtores());
				this.filmeRepository.save(filme);
			
			}
		}
	
	}
		
	private List<Atores> verificaSeAtorExiste(FilmeCadastroDTO filmeDto) {
		List<Atores> novaLista = new ArrayList<>();
		Atores verifica;
		
		for(AtoresCadastroDTO autor: filmeDto.atores()) {
			verifica = this.atoresRepository.findByNomeCompleto(autor.nomeCompleto().toUpperCase().trim());
			
			if(verifica != null) {
				novaLista.add(verifica); 
			}else {
				novaLista.add(new Atores(autor));
			}
		} 
		return novaLista;
	}
}