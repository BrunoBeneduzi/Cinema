package com.projetoCinema.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.projetoCinema.cinema.model.Filme;

public interface FilmesRepository extends JpaRepository<Filme, Long>{
	
	Filme findByNomeFilme(String nomeFilme);
	
	Filme findByNomeDiretor(String nomeDiretor);
	 
	@Query("SELECT f FROM Filme f LEFT JOIN FETCH f.atores WHERE (:nomeFilme IS NULL OR f.nomeFilme LIKE CONCAT('%', :nomeFilme, '%'))")
	List<Filme> buscarFilmesComAtoresPorNomeDeFilme(@Param("nomeFilme") String nomeFilme);
	
	@Query("SELECT f FROM Filme f LEFT JOIN FETCH f.atores WHERE (:nomeDiretor IS NULL OR f.nomeDiretor LIKE CONCAT('%', :nomeDiretor, '%'))")
	List<Filme> buscarFilmesComAtoresPorNomeDoDiretor(@Param("nomeDiretor") String nomeDiretor);
	
	@Query("SELECT f FROM Filme f LEFT JOIN FETCH f.atores WHERE (:id IS NULL OR f.id = :id)")
	List<Filme> buscarFilmesComAtoresPorIdDeFilme(@Param("id") Long id);
	
	@Query("SELECT f FROM Filme f LEFT JOIN FETCH f.atores WHERE (:notaMinima IS NULL OR f.nota >= :notaMinima)")
	List<Filme> buscarFilmesComAtoresPorNotaMinima(@Param("notaMinima") Double notaMinima);

}