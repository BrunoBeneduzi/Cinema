package com.projetoCinema.cinema.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "usuario")
@Entity(name = "Usuario")
public class Usuario implements UserDetails{ 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	/*UserDetails, está dizendo ao Spring Security:
	“Aqui estão os dados do meu usuário, como nome, senha e permissões, para que você possa fazer login e verificar o que ele pode acessar.”
	ou seja, essa interace fala para o spring que essa é a classe onde ele vai buscar o login e senha quando requisitado.
	*/
	private Long id;
	private String login;
	private String senha;
	
	public Usuario() {
		
	}
	
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.login;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
}