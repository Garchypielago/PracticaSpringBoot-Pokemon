package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name="regions")
public class Region{
    @Id
    private int id;
    @Column
    private String name;

    @OneToMany(mappedBy = "regions")
    Set<Pokemon> pokemonSet;
}
