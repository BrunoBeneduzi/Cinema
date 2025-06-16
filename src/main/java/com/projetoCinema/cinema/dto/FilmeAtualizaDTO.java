package com.projetoCinema.cinema.dto;

import java.time.LocalDate;

public record FilmeAtualizaDTO(Long id, String nomeFilme, Double nota, String nomeDiretor, LocalDate dataDeLancamento) {

}