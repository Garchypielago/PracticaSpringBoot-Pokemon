package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Order(999)
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.ignoringRequestMatchers("/cart/api/**"))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/",
                                "/index",
                                "/login",
                                "/checkout",
                                "/shop/**",
                                "/product-details/**",
                                "/actuator/health",
                                "/actuator/info",
                                "/error"
                        ).permitAll()
                        .requestMatchers(
                                "/css/**",
                                "/js/**",
                                "/img/**",
                                "/fonts/**",
                                "/shopedex/**",
                                "/scss/**",
                                "/style.css",
                                "/admin/typesPokemon.css"
                        ).permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/cart/**").authenticated()
                        .anyRequest().authenticated())
                .formLogin(login -> login
                        .loginPage("/login")
                        .usernameParameter("email")
                        .defaultSuccessUrl("/", true)
                        .permitAll())
                .logout(logout -> logout
                        .logoutSuccessUrl("/?logout")
                        .permitAll());

        return http.build();
    }
}

