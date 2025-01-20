package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="ratings")
public class Rating {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pokemon_id")
    private Pokemon pokemon;

    @Column(nullable = false)
    private Float mark;

    @Column(unique = true ,nullable = false)
    private String userName;

    @Column
    private String review;

}
