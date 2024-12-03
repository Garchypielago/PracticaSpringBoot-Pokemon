package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.products;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Entity;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.enums.Regions;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.enums.Types;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
@Getter
@Setter
@AllArgsConstructor
public class Pokemon implements Entity<Long> {
    private Long id;
    private String nombre;
    private String descripcion;
    private Map<String,Integer> stats;
    private Types type1;
    private Types type2;
    private Regions region;
    private boolean legendary;
}
