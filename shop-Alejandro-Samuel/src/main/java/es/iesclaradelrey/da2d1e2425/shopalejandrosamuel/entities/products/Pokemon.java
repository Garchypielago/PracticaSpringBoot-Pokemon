package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.products;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Entity;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.categories.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
public class Pokemon implements Entity<Long> {
    private Long id;
    private String name;
    private String descripcion;
    private Map<String,Integer> stats;
    private Optional<Category> type1;
    private Optional<Category> type2;
    private Optional<Category> region;
    private boolean legendary;

    public Pokemon(Long id, String nombre, Optional<Category> region) {
        this.id = id;
        this.name = nombre;
        this.region = region;
    }
}
