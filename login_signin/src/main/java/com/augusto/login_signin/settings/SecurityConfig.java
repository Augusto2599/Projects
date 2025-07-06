package com.augusto.login_signin.settings;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desativa CSRF (necessário para testes com Postman)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**", "/static/**", "/**.html").permitAll() // libera rotas do login
                        .anyRequest().authenticated() // outras ainda protegidas
                )
                .formLogin(form -> form.disable()); // desativa o login padrão do Spring

        return http.build();
    }
}