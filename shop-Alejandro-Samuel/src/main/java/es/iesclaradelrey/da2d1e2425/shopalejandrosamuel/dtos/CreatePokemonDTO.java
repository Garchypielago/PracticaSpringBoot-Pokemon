package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Region;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.StatValue;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePokemonDTO {
    private String name;
    private String descripcion;
    private Double price;
    private Long stock;
    private Type type1;
    private Type type2;
    private Region region;
    private boolean legendary;

    private String nameReference;

}
