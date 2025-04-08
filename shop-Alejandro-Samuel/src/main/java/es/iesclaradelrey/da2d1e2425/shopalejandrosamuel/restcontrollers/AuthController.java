package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.restcontrollers;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.RegisterUserDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.TokensDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @PostMapping("/register")
    public ResponseEntity<TokensDTO> register(@RequestBody RegisterUserDTO registerUserDTO){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @PostMapping("/login")
    public ResponseEntity<TokensDTO> login(@RequestBody LoginUserDTO loginUserDTO){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @PostMapping("/refresh")
    public ResponseEntity<TokensDTO> refresh(){

        throw new UnsupportedOperationException("Not supported yet.");
    }

    @PostMapping("/revoke")
    public ResponseEntity<TokensDTO> revokeToken(){

        throw new UnsupportedOperationException("Not supported yet.");
    }
}
