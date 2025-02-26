package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Region;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Type;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreatePokemonDTO {
    private String name;
    private String description;
    private Type type1;
    private Type type2;
    private Region region;
    private boolean legendary;

    private Long stock;
    private Long idReference;

}
