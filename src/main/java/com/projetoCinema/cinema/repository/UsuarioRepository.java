package com.projetoCinema.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.projetoCinema.cinema.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	UserDetails findByLogin(String login);

}