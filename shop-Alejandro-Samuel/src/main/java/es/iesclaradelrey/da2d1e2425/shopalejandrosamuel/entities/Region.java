package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities;

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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Region {
    @Id
    private int id;
    @Column
    private String name;
}
