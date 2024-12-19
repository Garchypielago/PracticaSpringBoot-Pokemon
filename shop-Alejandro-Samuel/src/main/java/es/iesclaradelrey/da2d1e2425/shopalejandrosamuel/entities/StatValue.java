package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name="statValues")
public class StatValue {
    @Id
    private int idPokemon;
    @Id
    private int idStat;

    @Column(unique=true, nullable = false)
    private int value;
}
