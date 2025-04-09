package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.AppUser;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.enums.JwtTokenType;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${security.jwt.signing-key-secret}")
    private String signingKeySecret;

    @Value("${security.jwt.access-token-ttl}")
    private long accessToken;

    @Value("${security.jwt.refresh-token-ttl}")
    private long refreshToken;

    @Override
    public String generateAccessToken(AppUser appUser) {
        SecretKey key = Keys.hmacShaKeyFor(signingKeySecret.getBytes());

        return Jwts.builder()
                .claim("type", JwtTokenType.ACCESS)
                .subject(appUser.getEmail())
                .claim("firstName", appUser.getFirstName())
                .claim("lastName", appUser.getLastName())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + accessToken))
                .signWith(key)
                .compact();
    }

    @Override
    public String generateRefreshToken(AppUser appUser) {
        SecretKey key = Keys.hmacShaKeyFor(signingKeySecret.getBytes());

        return Jwts.builder()
                .claim("type", JwtTokenType.REFRESH)
                .subject(appUser.getEmail())
                .claim("firstName", appUser.getFirstName())
                .claim("lastName", appUser.getLastName())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + accessToken))
                .signWith(key)
                .compact();
    }


    @Override
    public void validateAccessToken(String token) {
        Claims claims = getTokenClaims(token);
        JwtTokenType type = claims.get("type", JwtTokenType.class);
        if (type!=JwtTokenType.ACCESS) {
            throw new JwtException("Type of token not valid");
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public void validateRefreshToken(String token) {
        Claims claims = getTokenClaims(token);
        JwtTokenType type = claims.get("type", JwtTokenType.class);
        if (type!=JwtTokenType.REFRESH) {
            throw new JwtException("Type of token not valid");
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String extractUsername(String token) {
        Claims claims = getTokenClaims(token);

        return claims.getSubject();
    }

    private Claims getTokenClaims(String token) {
        SecretKey key = Keys.hmacShaKeyFor(signingKeySecret.getBytes());

        JwtParser parser = Jwts.parser().verifyWith(key).build();

        return parser.parseSignedClaims(token).getPayload();
    }

}
