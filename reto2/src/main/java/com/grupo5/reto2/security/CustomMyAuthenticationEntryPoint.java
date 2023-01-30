package com.grupo5.reto2.security;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomMyAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		
		if(response.getStatus() == 409) {
			response.sendError(response.getStatus());
			
		}else if(response.getStatus() == 204) {
			response.sendError(response.getStatus());
			
		}else if(response.getStatus() == 400) {
			response.sendError(response.getStatus());
			
		} else {
			// Si el token no es valido o no se envia
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authorization Failed");
		}
	}

}
