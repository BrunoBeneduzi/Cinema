package com.projetoCinema.cinema.dto;

import java.time.LocalDate;

public record AtoresRetornoDTO(Long id, String nomeCompleto, LocalDate dataDeNascimento, Long qtdPremios, String nacionalidade) {

}
