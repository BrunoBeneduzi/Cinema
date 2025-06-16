package com.projetoCinema.cinema.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



/*
 ✅ @Configuration
Indica que essa classe fornece configurações para o Spring (é um bean de configuração).

✅ @EnableWebSecurity
Habilita a segurança da web com Spring Security.

Permite personalizar as configurações de segurança.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    return http.csrf(csrf -> csrf.disable())//Desativa a proteção CSRF (Cross Site Request Forgery).
	            .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))//Define a política de criação de sessões como "stateless" (sem estado), Isso significa que o servidor não armazenará sessões para os usuários — cada requisição deve conter todos os dados necessários para autenticação (ex: um token JWT).
	            .build();
	}
	
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	


	
	 
}