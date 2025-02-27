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
    @NotBlank(message = "New Pokemon must have name.")
    private String name;

    @NotBlank(message = "New Pokemon must have description.")
    private String description;

    @NotNull(message = "New Pokemon must have at least one type.")
    private Type type1;

    private Type type2;

    @NotNull(message = "New Pokemon must have region.")
    private Region region;

    private boolean legendary;

    @NotNull(message = "New Pokemon must have the stock.")
    @Digits(integer = 3, fraction = 0, message = "We only have space for 999 pokemons.")
    private Long stock;

    @NotNull(message = "Must have a pokemon for statistics and price reference.")
    private Long idReference;

}
