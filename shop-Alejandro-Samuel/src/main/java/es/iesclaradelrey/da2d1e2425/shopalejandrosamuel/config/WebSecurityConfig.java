package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Order(999)
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf ->
                        csrf.ignoringRequestMatchers("/api/cart"))
                .headers(heather ->
                        heather.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/css").permitAll()
                        .requestMatchers("/login/**").permitAll()
                        .anyRequest().authenticated())
                .formLogin(login -> login
                        .loginPage("/login")
                        .usernameParameter("email"));

        return http.build();
    }

}

