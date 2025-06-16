package com.projetoCinema.cinema.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.projetoCinema.cinema.dto.FilmeCadastroDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "filme")
public class Filme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nomeFilme", nullable = false, unique = true)
	private String nomeFilme;
	@Column(name = "nota", nullable = false)
	private Double nota;
	@Column(name = "nomeDiretor", nullable = false)
	private String nomeDiretor;
	@Column(name = "dataDeLancamento", nullable = false)
	private LocalDate dataDeLancamento;
	@ManyToMany
	private List<Atores> atores = new ArrayList<>();
	
	public Filme() {}
	
	public Filme(FilmeCadastroDTO filme) {
		this.nomeFilme = filme.nomeFilme().toUpperCase().trim();
		this.nota = filme.nota();
		this.nomeDiretor = filme.nomeDiretor().toUpperCase().trim();
		this.dataDeLancamento = filme.dataDeLancamento();
	}
	
	public String getNomeFilme() {
		return nomeFilme;
	}
	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme.toUpperCase().trim();
	}
	public Double getNota() {
		return nota;
	}
	public void setNota(Double nota) {
		this.nota = nota;
	}
	public String getNomeDiretor() {
		return nomeDiretor.toUpperCase().trim();
	}
	public void setNomeDiretor(String nomeDiretor) {
		this.nomeDiretor = nomeDiretor;
	}
	public LocalDate getDataDeLancamento() {
		return dataDeLancamento;
	}
	public void setDataDeLancamento(LocalDate dataDeLancamento) {
		this.dataDeLancamento = dataDeLancamento;
	}
	public List<Atores> getAtores() {
		return atores;
	}

	public void setAtores(List<Atores> atores) {
		this.atores.addAll(atores);
	}

	public Long getId() {
		return id;
	}
}