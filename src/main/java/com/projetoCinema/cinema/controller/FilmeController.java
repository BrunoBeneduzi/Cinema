package com.projetoCinema.cinema.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.projetoCinema.cinema.dto.FilmeAtualizaDTO;
import com.projetoCinema.cinema.dto.FilmeCadastroDTO;
import com.projetoCinema.cinema.service.AtualizarFilme;
import com.projetoCinema.cinema.service.CadastroFilmeAtor;
import com.projetoCinema.cinema.service.DeletaFilme;
import com.projetoCinema.cinema.service.ListagemFilmesAtor;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController //Usado para marcar a classe como um controlador que lida com requisições http
@RequestMapping("/filme")
@SecurityRequirement(name = "bearer-key")
public class FilmeController {

	@Autowired
	private CadastroFilmeAtor cadastro;
	@Autowired
	private ListagemFilmesAtor listar;
	@Autowired
	private AtualizarFilme atualiza;
	@Autowired
	private DeletaFilme deletar;
	
	@PostMapping
	@Transactional //Se alguma parte da operação falhar, tudo é desfeito automaticamente (rollback).
	public ResponseEntity<List<FilmeCadastroDTO>> adicionarFilmeAtor(@RequestBody @Valid List<FilmeCadastroDTO> filmeDto){
		
		this.cadastro.cadastrarFilmeAutor(filmeDto);
			
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping
	public ResponseEntity retornaFilmes(
			@RequestParam(required = false) Long id,
			@RequestParam(required = false) String nomeFilme,
			@RequestParam(required = false) String nomeDiretor,
			@RequestParam(required = false) Double nota) {
		
		return ResponseEntity.ok(listar.retornaFilmeAtor(nomeFilme, nomeDiretor, id, nota));
	}
	
	@PutMapping("{id}")
	@Transactional
	public ResponseEntity atualizaFilme(@PathVariable Long id, @RequestBody FilmeAtualizaDTO filmeDto) {
			
		return ResponseEntity.ok(this.atualiza.atualizaFilme(id, filmeDto));	
	}
	 
	@DeleteMapping("/{id}")
	public ResponseEntity excluirFilme(@PathVariable Long id) {
		
		this.deletar.deletaFilme(id);
		
		 return ResponseEntity.noContent().build(); // HTTP 204
		
	}	
}