package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AppTypeDTO {

    private Long id;

    private String name;

    private String background;
}