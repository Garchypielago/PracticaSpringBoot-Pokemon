package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterUserDTO {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
