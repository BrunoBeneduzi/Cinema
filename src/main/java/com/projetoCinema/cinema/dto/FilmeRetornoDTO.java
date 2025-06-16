package com.projetoCinema.cinema.dto;

import java.time.LocalDate;
import java.util.List;

public record FilmeRetornoDTO(Long id, String nomeFilme, Double nota, String nomeDiretor, LocalDate dataDeLancamento, List<AtoresRetornoDTO> atores) { 

}