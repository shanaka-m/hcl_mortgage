package com.squad3.hcl_mortgage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChainDev(HttpSecurity http) throws Exception {
		
		
		http
			.csrf((csrf) -> csrf.disable())
			.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
					.requestMatchers(
							"/swagger-ui/**",
							"/swagger-resources/**",
			                "/swagger-ui.html",
			                "/v3/api-docs/**",
			                "/webjars/**",
			                "/account/**").permitAll()
					.anyRequest().authenticated())
			.formLogin((formLogin) -> formLogin.disable());
		/*
		http
			.csrf((csrf) -> csrf.disable())
			.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
			*/
			
		return http.build();
			
	}
}
