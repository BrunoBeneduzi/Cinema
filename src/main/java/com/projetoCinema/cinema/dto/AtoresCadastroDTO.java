package com.projetoCinema.cinema.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;

public record AtoresCadastroDTO(
		@NotBlank(message = "o nome do ator não pode estar em branco")
		String nomeCompleto,
		LocalDate dataDeNascimento,
		Long qtdPremios,
		@NotBlank(message = "a nacionalidade do ator não pode estar em branco")
		String nacionalidade) {
}