package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.categories;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Category implements Entity<Long> {
    private Long id;
    private String name;
    private String description;

}
