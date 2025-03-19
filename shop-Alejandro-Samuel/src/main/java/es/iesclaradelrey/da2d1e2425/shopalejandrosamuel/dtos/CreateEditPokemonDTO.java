package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Pokemon;
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
public class CreateEditPokemonDTO {

    private Long id;

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

    @NotNull(message = "Edit Pokemon must have the price.")
    private Double price;

    public CreateEditPokemonDTO(Pokemon pokemon) {
        this.id = pokemon.getId();
        this.name = pokemon.getName();
        this.description = pokemon.getDescription();
        this.type1 = pokemon.getType1();
        this.type2 = pokemon.getType2();
        this.region = pokemon.getRegion();
        this.legendary = pokemon.isLegendary();
        this.stock = pokemon.getStock();
        this.price = pokemon.getPrice();
    }
}
