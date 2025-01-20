package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name="stat_values", uniqueConstraints = {@UniqueConstraint(columnNames = {"pokemon_id", "stat_id"})})
public class StatValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pokemon_id")
    private Pokemon pokemon;

    @ManyToOne
    @JoinColumn(name = "stat_id")
    private Stat stat;

    @Column(nullable = false)
    private int statValue;
}
