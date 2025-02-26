package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Region;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Type;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreatePokemonDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotNull
    private Type type1;
    private Type type2;
    @NotNull
    private Region region;
    private boolean legendary;
    @NotNull
    @Digits(integer = 10, fraction = 0)
    private Long stock;
    @NotNull
    @Digits(integer = 10, fraction = 0)
    private Long idReference;

}
