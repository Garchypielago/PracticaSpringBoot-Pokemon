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
@Table(name="stats")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Stat {
    @Id
    private int id;

    @Column(unique=true, nullable = false)
    private String name;
}
