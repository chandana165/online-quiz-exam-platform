package com.quizplatform.config;

import com.quizplatform.security.BearerTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.List;

@Configuration
public class SecurityConfig {
 @Bean PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }
 @Bean SecurityFilterChain filterChain(HttpSecurity http, BearerTokenFilter tokenFilter) throws Exception {
  return http.csrf(csrf -> csrf.disable()).cors(cors -> cors.configurationSource(corsConfigurationSource()))
   .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
   .authorizeHttpRequests(a -> a.requestMatchers("/api/auth/**").permitAll().anyRequest().authenticated())
   .addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class).build();
 }
 @Bean CorsConfigurationSource corsConfigurationSource() {
  CorsConfiguration c = new CorsConfiguration(); c.setAllowedOrigins(List.of("http://localhost:5173"));
  c.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS")); c.setAllowedHeaders(List.of("*"));
  c.setAllowCredentials(false); UrlBasedCorsConfigurationSource s = new UrlBasedCorsConfigurationSource();
  s.registerCorsConfiguration("/**", c); return s;
 }
}
