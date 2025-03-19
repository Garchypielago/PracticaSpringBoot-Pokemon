package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Region;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateEditRegionDTO {

    private Long id;

    @NotBlank
    private String name;

    public CreateEditRegionDTO(Region region) {
        this.id = region.getId();
        this.name = region.getName();
    }
}
