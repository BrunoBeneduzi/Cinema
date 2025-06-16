package com.projetoCinema.cinema.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.projetoCinema.cinema.dto.AtoresCadastroDTO;
import com.projetoCinema.cinema.dto.FilmeCadastroDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "atores")
public class Atores {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nomeCompleto", nullable = false, unique = true)
	private String nomeCompleto;
	@Column(name = "dataDeNascimento", nullable = false)
	private LocalDate dataDeNascimento;
	@Column(name = "quantidadeDePremios", nullable = false)
	private Long qtdPremios;
	@Column(name = "nacionalidade", nullable = false)
	private String nacionalidade;
	@ManyToMany(mappedBy = "atores")
	private List<Filme> filme = new ArrayList<>();
	
	public Atores() {}
	
	public Atores(AtoresCadastroDTO atores) {
		this.nomeCompleto = atores.nomeCompleto().toUpperCase().trim();
		this.dataDeNascimento = atores.dataDeNascimento();
		this.qtdPremios = atores.qtdPremios();
		this.nacionalidade = atores.nacionalidade().toUpperCase().trim();
	}
	
	


	public String getNomeCompleto() {
		return nomeCompleto;
	}


	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto.toUpperCase().trim();
	}


	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}


	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}


	public Long getQtdPremios() {
		return qtdPremios;
	}


	public void setQtdPremios(Long qtdPremios) {
		this.qtdPremios = qtdPremios;
	}


	public String getNacionalidade() {
		return nacionalidade;
	}


	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade.toUpperCase().trim();
	}    


	public List<Filme> getFilme() {
		return filme;
	}


	public void setFilme(List<Filme> filme) {
		this.filme = filme;
	}


	public Long getId() {
		return id;
	}	
	
	
}