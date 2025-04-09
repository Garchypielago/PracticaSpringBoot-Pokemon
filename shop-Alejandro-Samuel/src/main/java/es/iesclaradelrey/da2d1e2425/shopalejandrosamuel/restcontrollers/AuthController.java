package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.restcontrollers;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.RegisterUserDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.TokensDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.AppUser;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.AppUserService;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AppUserService appUserService;
    private final JwtService jwtService;

    public AuthController(AppUserService appUserService, JwtService jwtService) {
        this.appUserService = appUserService;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<TokensDTO> register(@RequestBody RegisterUserDTO registerUserDTO) {
        AppUser appUser = appUserService.register(registerUserDTO);
        String accessToken = jwtService.generateAccessToken(appUser);
        String refreshToken = jwtService.generateRefreshToken(appUser);

        return ResponseEntity.ok(TokensDTO.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build()
        );
    }

    @PostMapping("/login")
    public ResponseEntity<TokensDTO> login(@RequestBody LoginUserDTO loginUserDTO) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @PostMapping("/refresh")
    public ResponseEntity<TokensDTO> refresh() {

        throw new UnsupportedOperationException("Not supported yet.");
    }

    @PostMapping("/revoke")
    public ResponseEntity<TokensDTO> revokeToken() {

        throw new UnsupportedOperationException("Not supported yet.");
    }
}
