package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CreateCategoryDTO {
    private Long categoryType;

    @NotBlank(message = "New Region must have name.")
    private String name;
    private String background;
}
