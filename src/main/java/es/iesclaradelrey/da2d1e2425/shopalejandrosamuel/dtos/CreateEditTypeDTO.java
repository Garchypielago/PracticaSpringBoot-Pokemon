package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Type;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateEditTypeDTO {

    @NotBlank(message = "Edit Type must have name.")
    private String name;

    private String background;

    public CreateEditTypeDTO(Type type) {
        this.name = type.getName();
        this.background = type.getBackground();
    }
}
