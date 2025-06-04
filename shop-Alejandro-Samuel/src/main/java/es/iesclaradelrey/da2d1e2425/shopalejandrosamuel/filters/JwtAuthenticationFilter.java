package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.filters;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.JwtService;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {


    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    // Nombre de la cabecera de autorización
    private static final String AUTH_HEADER = "Authorization";
    // Prefijo que precede al token JWT
    private static final String BEARER_PREFIX = "Bearer ";
    // Ruta que se desea proteger
    private static final String PROTECTED_PATH = "/api/app/**";
    // Matcher para comprobar si una petición está en la ruta protegida
    private static final AntPathRequestMatcher protectedPathMatcher = new AntPathRequestMatcher(PROTECTED_PATH);

    public JwtAuthenticationFilter(JwtService jwtService,
                                   UserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {

        System.out.println("Antes del if");
        if (protectedPathMatcher.matches(request)) {
            System.out.println("Despues del if");

            try {
                String authHeader = request.getHeader(AUTH_HEADER);

                if (authHeader == null || !authHeader.startsWith(BEARER_PREFIX)) {
                    throw new JwtException("Authorization header missing or incorrect.");
                }

                String token = authHeader.substring(7);

                jwtService.validateAccessToken(token);

                String username = jwtService.extractUsername(token);

                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
