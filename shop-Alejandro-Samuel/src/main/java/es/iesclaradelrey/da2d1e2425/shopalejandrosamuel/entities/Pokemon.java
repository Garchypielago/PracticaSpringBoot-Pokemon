package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="pokemones")
public class Pokemon {

    @Id
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false, length = 25)
    private String name;

    @Column(nullable = false, length = 100)
    private String descripcion;

    @OneToMany(mappedBy = "pokemon")
    private Collection<StatValue> stats;

    @ManyToOne
    @JoinColumn(name="type1", nullable = false)
    private Type type1;

    @ManyToOne
    @JoinColumn(name="type2")
    private Type type2;

    @ManyToOne
    @JoinColumn(name="region", nullable = false)
    private Region region;

    @Column(nullable = false)
    private boolean legendary;

    public Pokemon(Long id, String nombre) {
        this.id = id;
        this.name = nombre;
    }
}
