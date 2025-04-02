package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Pokemon;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AppPokemonDTO {

    private Long id;

    private String name;

    private String description;

    private Long type1;

    private Long type2;

    private Long region;

    private boolean legendary;

    private Long stock;

    private Double price;

    private String url;

    public AppPokemonDTO(Pokemon pokemon) {
        this.id = pokemon.getId();
        this.name = pokemon.getName();
        this.description = pokemon.getDescription();
        this.type1 = pokemon.getType1().getId();
        if(pokemon.getType2() != null){
            this.type2 = pokemon.getType2().getId();
        }else {
            this.type2 = null;
        }
        this.region = pokemon.getRegion().getId();
        this.legendary = pokemon.isLegendary();
        this.stock = pokemon.getStock();
        this.price = pokemon.getPrice();
        this.url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + pokemon.getId() + ".png";
    }
}
