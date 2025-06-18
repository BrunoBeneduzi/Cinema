package com.projetoCinema.cinema.seguranca;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.projetoCinema.cinema.configuration.TokenService;
import com.projetoCinema.cinema.repository.UsuarioRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


//Esses metodos são gerenciados pelo spring e não precisam ser instanciados, quando bate uma requisição o spring traz para cá para os filtros fazerem o trabalho
@Component
public class SecurityFilter extends OncePerRequestFilter{
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TokenService tokenService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		
		var tokenJWT = recuperarToken(request);
		
		if(tokenJWT != null) {
			var subject = tokenService.getSubject(tokenJWT);//valida o token
			var usuario = usuarioRepository.findByLogin(subject);
			
			var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		
		
		filterChain.doFilter(request, response);
	}

	private String recuperarToken(HttpServletRequest request) {
		var authorizationHeader = request.getHeader("Authorization");
		
		if(authorizationHeader != null) {
			
			return authorizationHeader.replace("Bearer ","");//se nao tirar o bearer ele manda o token com essa informação e dá erro
		}
		
		return null;
	}

}