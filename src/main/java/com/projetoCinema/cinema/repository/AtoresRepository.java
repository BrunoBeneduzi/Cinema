package com.projetoCinema.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.projetoCinema.cinema.model.Atores;



public interface AtoresRepository extends JpaRepository<Atores, Long>{
	
	Atores findByNomeCompleto(String nomeCompleto);
	
	List<Atores> findByNacionalidade(String nacionalidade);
	
	@Query("SELECT a FROM Atores a WHERE (:nomeCompleto IS NULL OR a.nomeCompleto LIKE CONCAT('%', :nomeCompleto, '%'))")
	List<Atores> buscarAtoresPorNome(@Param("nomeCompleto") String nomeCompleto);

}
