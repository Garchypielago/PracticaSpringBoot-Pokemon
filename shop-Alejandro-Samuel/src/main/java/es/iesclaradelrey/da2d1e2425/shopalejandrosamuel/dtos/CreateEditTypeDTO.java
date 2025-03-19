package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Type;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateEditTypeDTO {

    private Long id;

    @NotBlank
    private String name;

    private String background;

    public CreateEditTypeDTO(Type type) {
        this.id = type.getId();
        this.name = type.getName();
        this.background = type.getBackground();
    }
}
