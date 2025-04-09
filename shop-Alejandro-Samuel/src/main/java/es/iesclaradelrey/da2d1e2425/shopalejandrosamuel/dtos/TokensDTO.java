package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TokensDTO {
    private String accessToken;
    private String refreshToken;
}
