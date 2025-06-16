package com.projetoCinema.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projetoCinema.cinema.model.Atores;


public interface AtoresRepository extends JpaRepository<Atores, Long>{
	
	Atores findByNomeCompleto(String nomeCompleto);
}
