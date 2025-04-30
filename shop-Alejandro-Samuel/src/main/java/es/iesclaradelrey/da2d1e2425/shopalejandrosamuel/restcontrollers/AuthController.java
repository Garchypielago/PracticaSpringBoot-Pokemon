package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.restcontrollers;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.LoginUserDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.RegisterUserDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.TokensDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.AppUser;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.AppUserService;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.AuthService;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.JwtService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<TokensDTO> register(@RequestBody RegisterUserDTO registerUserDTO) {
        return ResponseEntity.ok(authService.register(registerUserDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<TokensDTO> login(@RequestBody LoginUserDTO loginUserDTO) {
        return ResponseEntity.ok(authService.login(loginUserDTO));
    }

    @PostMapping("/refresh")
    public ResponseEntity<TokensDTO> refresh(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        return ResponseEntity.ok(authService.refresh(authHeader));
    }

    @PostMapping("/revoke")
    public ResponseEntity<Void> revoke() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
