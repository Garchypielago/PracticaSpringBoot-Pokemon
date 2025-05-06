package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.config;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.filters.JwtAuthenticationFilter;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.AppUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.*;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@Order(3)
public class ApiSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthenticationFilter jwtAuthenticationFilter) throws Exception {
        http.securityMatcher("/api/**");

        http.csrf(config -> config
                .ignoringRequestMatchers("/api/**")
        );

        http.authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers("/api/app/**").authenticated()
                                .anyRequest().permitAll()
                );

        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }





}
