package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.PokemonRepository;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.PokemonService;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
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
    private String description;

    @Column
    private Double price;

    @Column(nullable = false, columnDefinition = "bigint default 5")
    private Long stock;

    @OneToMany(mappedBy = "pokemon", fetch = FetchType.EAGER)
    private Collection<StatValue> stats = new ArrayList<>();

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

    public Pokemon(Long id, String nombre, String description, Type tipo1, Type tipo2, Region region, boolean legendary, Long stock) {
        this.id = id;
        this.name = nombre;
        this.description = description;
        this.type1 = tipo1;
        this.type2 = tipo2;
        this.region = region;
        this.legendary = legendary;
        this.stock = stock;
    }

    public double calcPrice() {

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
