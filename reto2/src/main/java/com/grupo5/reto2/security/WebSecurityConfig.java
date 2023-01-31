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
		
		http.authorizeHttpRequests(
				(authz) ->
					authz
						
						.requestMatchers("/api/users/login").permitAll()
						.requestMatchers("/api/users/signup").permitAll()
//						.requestMatchers("/api/professors/**").hasAnyAuthority(Rol.Admin.name(), Rol.Professor.name())
						.requestMatchers("/api/users").hasAnyAuthority(Rol.Admin.name())
						.requestMatchers("/api/professors/create").permitAll()
						.requestMatchers("/api/students/create").permitAll()
						.requestMatchers("/api/grades/**").permitAll()
						.requestMatchers("/api/gradeEditions/**").permitAll()
						.requestMatchers("/api/sendMail").permitAll()
//						.anyRequest().permitAll()
						.anyRequest().authenticated()
		);
		
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
        // The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*' when the request's credentials mode is 'include'.
        configuration.setAllowCredentials(true);
        // setAllowedHeaders is important! Without it, OPTIONS preflight request
        // will fail with 403 Invalid CORS request
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

//en el filterChain, antes de hacer el return http.build(); añadir la línea

	
//	@Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**").allowedMethods("*");
//    }
}