package com.projetoCinema.cinema.dto;

import java.time.LocalDate;
import java.util.List;
import jakarta.validation.constraints.NotBlank;

public record FilmeCadastroDTO(
		@NotBlank(message = "o nome do filme não pode estar em branco")
		String nomeFilme,
		Double nota,
		@NotBlank(message = "o nome do diretor não pode estar em branco")
		String nomeDiretor,
		LocalDate dataDeLancamento,
		List<AtoresCadastroDTO> atores
		) {

}
