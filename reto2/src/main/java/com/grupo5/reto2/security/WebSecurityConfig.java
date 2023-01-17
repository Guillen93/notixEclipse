package com.grupo5.reto2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.grupo5.reto2.role.Rol;

@Configuration
public class WebSecurityConfig {

	@Autowired 
	private JwtTokenFilter jwtTokenFilter;
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
//		return new HashPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.authorizeHttpRequests(
				(authz) ->
					authz
						.requestMatchers("/api/users/signup").permitAll()
						.requestMatchers("/api/users/login").permitAll()
//						.requestMatchers("/api/professors/**").hasAnyAuthority(Rol.Admin.name(), Rol.Professor.name())
						.requestMatchers("/api/students/**").permitAll()
						.requestMatchers("/api/grades/**").permitAll()
						.requestMatchers("/api/gradeEditions/**").permitAll()
						.anyRequest().permitAll()
//						.anyRequest().authenticated()
		);
		
		http.exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler());
		http.exceptionHandling().authenticationEntryPoint(new CustomMyAuthenticationEntryPoint());

		http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
}