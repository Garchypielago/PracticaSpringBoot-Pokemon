package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;


@NoArgsConstructor
@Getter
@Setter
@ToString
public class AppRegionDTO {

    private Long id;

    private String name;

    public AppRegionDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
