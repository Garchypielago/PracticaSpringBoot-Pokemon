package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.enums.Regions;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.enums.Types;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name="regions")
public class Region extends Category{
    @Id
    private int id;
    @Column
    private String name;

}
