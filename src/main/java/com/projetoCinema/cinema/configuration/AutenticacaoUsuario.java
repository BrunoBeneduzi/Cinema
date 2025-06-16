package com.projetoCinema.cinema.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projetoCinema.cinema.repository.UsuarioRepository;

@Service
public class AutenticacaoUsuario implements UserDetailsService{
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return usuarioRepository.findByLogin(username);
	}

	
}