package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "ratings", uniqueConstraints = @UniqueConstraint(columnNames = {"pokemon_id", "username"}))
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pokemon_id", nullable = false)
    private Pokemon pokemon;

    @Column(nullable = false)
    private Float mark;

    @Column(name = "username", nullable = false)
    private String userName;

    @Column
    private String review;

}
