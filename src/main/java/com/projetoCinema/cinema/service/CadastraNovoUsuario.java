package com.projetoCinema.cinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.projetoCinema.cinema.dto.DadosLoginDTO;
import com.projetoCinema.cinema.model.Usuario;
import com.projetoCinema.cinema.repository.UsuarioRepository;

@Service
public class CadastraNovoUsuario {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public DadosLoginDTO cadastraUsuario(DadosLoginDTO login) {
		Usuario usuario = null;
		
		if(this.usuarioRepository.findByLogin(login.login()) != null) {
			return null;
		}else {
			usuario = new Usuario(login.login(), this.passwordEncoder.encode(login.senha()));
			this.usuarioRepository.save(usuario);
			return login;
		}
		
	}
}