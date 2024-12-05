package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.categories;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Entity;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.enums.Regions;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.enums.Types;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class Category implements Entity<Long> {
    private Long id;
    private String name;
    private Regions region;
    private Types type;
    private String background;

    public Category(Long id, String name, Regions region) {
        this.id = id;
        this.name = name;
        this.region = region;
    }

    public Category(Long id, String name, Types type, String background) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.background = background;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Category category)) return false;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, region, type);
    }
}
