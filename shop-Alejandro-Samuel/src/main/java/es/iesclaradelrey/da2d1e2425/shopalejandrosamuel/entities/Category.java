package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.enums.Regions;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.enums.Types;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Category {
    private Long id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Category category)) return false;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
