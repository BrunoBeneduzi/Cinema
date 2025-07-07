package com.projetoCinema.cinema.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projetoCinema.cinema.configuration.DadosTokenJwtDTO;
import com.projetoCinema.cinema.configuration.TokenService;
import com.projetoCinema.cinema.dto.DadosLoginDTO;
import com.projetoCinema.cinema.model.Usuario;
import com.projetoCinema.cinema.service.CadastraNovoUsuario;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
	
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private CadastraNovoUsuario cadastrarUsuario;
	
	@PostMapping
	public ResponseEntity logar(@RequestBody @Valid DadosLoginDTO login) {
		var AutenticacaoToken = new UsernamePasswordAuthenticationToken(login.login(), login.senha()); //cria um token de autenticação contendo login e senha do usuario
		
		var autenticacao = this.manager.authenticate(AutenticacaoToken);//verifica se as credenciais estão corretas 
		
		var tokenJWT = tokenService.gerarToken((Usuario) autenticacao.getPrincipal());
		
		return ResponseEntity.ok(new DadosTokenJwtDTO(tokenJWT));
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity cadastrarUsuario(@RequestBody @Valid DadosLoginDTO login) {
		
		DadosLoginDTO dados = this.cadastrarUsuario.cadastraUsuario(login);
		
		if(dados != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(dados);
		}else {
			 return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe um usuário com esse e-mail cadastrado.");
		}
		
		
	}
	
	
}