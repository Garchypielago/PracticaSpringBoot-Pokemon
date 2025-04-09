package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.AppUser;

public interface JwtService {
    String generateAccessToken(AppUser appUser);

    String generateRefreshToken(AppUser appUser);

    void validateAccessToken(String token);

    void validateRefreshToken(String token);

    String extractUsername(String token);
}
