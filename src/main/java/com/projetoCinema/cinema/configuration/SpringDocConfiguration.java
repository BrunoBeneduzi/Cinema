package com.projetoCinema.cinema.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Component
public class SpringDocConfiguration {

	
	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                       .components(new Components()
                           .addSecuritySchemes("bearer-key",
                           new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));
   }
}