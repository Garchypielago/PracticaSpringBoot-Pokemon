package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Region;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateEditRegionDTO {

    @NotBlank(message = "Edit Type must have name.")
    private String name;

    public CreateEditRegionDTO(Region region) {
        this.name = region.getName();
    }
}
