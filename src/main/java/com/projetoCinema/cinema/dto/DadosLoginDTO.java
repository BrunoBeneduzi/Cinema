package com.projetoCinema.cinema.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosLoginDTO(
		@NotBlank(message = "Email é obrigatorio")
		@Email(message = "Email invalido")
		String login, 
		@NotBlank(message = "A senha é obrigatorio")
		String senha) {

}
