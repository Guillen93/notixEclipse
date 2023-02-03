package com.grupo5.reto2.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.grupo5.reto2.role.Rol;

@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {

	@Autowired
	private JwtTokenFilter jwtTokenFilter;

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
		return new HashPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.authorizeHttpRequests((authz) -> authz

				.requestMatchers("/api/users/login").permitAll()
				.requestMatchers("/api/users/signup").permitAll()
				.requestMatchers("/api/users/loginSinCifrado").permitAll()
				.requestMatchers("/api/users/signupSinCifrado").permitAll()
				.requestMatchers("/api/users/updatePass").permitAll()
				.requestMatchers("/api/users").hasAnyAuthority(Rol.Admin.name())
				.requestMatchers("/api/users/admin/").hasAnyAuthority(Rol.Admin.name())
				.requestMatchers("/api/users/professor/student").hasAnyAuthority(Rol.Admin.name())
				.requestMatchers("/api/professors/create").permitAll()
				.requestMatchers("/api/professorsUpdate/**").hasAnyAuthority(Rol.Admin.name(),Rol.Professor.name())
				.requestMatchers("/api/absencesUpdate/**").hasAnyAuthority(Rol.Admin.name(),Rol.Professor.name())
				.requestMatchers("/api/absencesDelete/**").hasAnyAuthority(Rol.Admin.name(),Rol.Professor.name())
				.requestMatchers("/api/studentsUpdate/**").hasAnyAuthority(Rol.Admin.name(),Rol.Student.name())
				.requestMatchers("/api/gradesAdmin/**").hasAnyAuthority(Rol.Admin.name())
				.requestMatchers("/api/roles").hasAnyAuthority(Rol.Admin.name())
				.requestMatchers("/api/roles/**").hasAnyAuthority(Rol.Admin.name())
				.requestMatchers("/api/subjectsUpdate").hasAnyAuthority(Rol.Admin.name())
				.requestMatchers("/api/subjectsUpdate/**").hasAnyAuthority(Rol.Admin.name())
				.requestMatchers("/api/gradesEditionsAdmin/**").hasAnyAuthority(Rol.Admin.name())
				.requestMatchers("/api/notesUpdate/**").hasAnyAuthority(Rol.Admin.name(),Rol.Professor.name())
				.requestMatchers("/api/students/create").permitAll()
				.requestMatchers("/api/sendMail").permitAll()
				.requestMatchers("/api/publicKey").permitAll()
				.requestMatchers("/v3/api-docs").permitAll()
				.requestMatchers("/v3/api-docs/**").permitAll()
				.requestMatchers("/swagger-ui/**").permitAll()				
				.anyRequest().authenticated());

		http.exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler());
		http.exceptionHandling().authenticationEntryPoint(new CustomMyAuthenticationEntryPoint());

		http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
		http.cors();
		return http.build();

	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		final CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("https://localhost:7285"));
		configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH"));
		// setAllowCredentials(true) is important, otherwise:
		// The value of the 'Access-Control-Allow-Origin' header in the response must
		// not be the wildcard '*' when the request's credentials mode is 'include'.
		configuration.setAllowCredentials(true);
		// setAllowedHeaders is important! Without it, OPTIONS preflight request
		// will fail with 403 Invalid CORS request
		configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}


}