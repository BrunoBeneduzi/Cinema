package com.projetoCinema.cinema.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.projetoCinema.cinema.seguranca.SecurityFilter;



/*
 ✅ @Configuration
Indica que essa classe fornece configurações para o Spring (é um bean de configuração).

✅ @EnableWebSecurity
Habilita a segurança da web com Spring Security.

Permite personalizar as configurações de segurança.
 */


//essa classe e a classe securityFilter, são filtros que são chamados sempre que existe uma requisisão http, para escolher qual vai vir primeiro, precisa colocar em um metodo
@Configuration
@EnableWebSecurity
public class SecurityConfigurations {
	
	@Autowired
	private SecurityFilter securityFilter;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    return http
	        .csrf(csrf -> csrf.disable()) // Desativa CSRF
	        .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Stateless
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers(HttpMethod.POST, "/login").permitAll()
	            .requestMatchers(HttpMethod.POST, "/login/cadastrar").permitAll()
	            .requestMatchers("/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**").permitAll()// Libera o login
	            .anyRequest().authenticated() // Protege qualquer outra rota
	        )
	        .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class) // Adiciona o filtro JWT antes da autenticação padrão
	        .build(); // Finaliza a configuração
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();//decodifica a senha 
	}
}