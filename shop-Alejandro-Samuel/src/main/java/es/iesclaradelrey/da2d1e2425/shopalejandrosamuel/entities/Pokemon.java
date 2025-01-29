package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Set;

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

    @Column(nullable = false, length = 200)
    private String descripcion;

    @OneToMany(mappedBy = "pokemon")
    private Collection<StatValue> stats;

    @OneToMany(mappedBy ="pokemon")
    private Set<ProductInCart> productInCart;

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
    public double getPrice() {

        double total=0;
        Collection<StatValue>stats = this.getStats();
        for (StatValue statValue : stats) {
            total+=statValue.getStatValue();
        }
        if(this.isLegendary()){
            total+=1250;
        }
        else if(total>=500){
            total+=300;
        }
        else if(total>=415){
            total+=100;
        }
        else if(total<=320 && total>300){
            total-=50;
        }
        else if(total<=300){
            total-=100;
        }
        total=total/4;
        total = (double) Math.round(total * 100) / 100;
        return total;
    }
}
