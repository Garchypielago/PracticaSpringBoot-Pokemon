package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="product_in_cart")
public class ProductInCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pokemon_id", nullable = false)
    private Pokemon pokemon;

    @Column
    private Long productNumber;

    @Column(columnDefinition = "timestamp default current_timestamp()", nullable = false, insertable = false, updatable = false )
    private LocalDateTime addedTime;
    @Column(columnDefinition = "timestamp default current_timestamp() on update current_timestamp()", nullable = false, insertable = false, updatable = false )
    private LocalDateTime modifiedTime;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser user;



    public ProductInCart(Pokemon pokemon, Long productNumber, AppUser user) {
        this.pokemon = pokemon;
        this.productNumber = productNumber;
        this.user = user;
    }

    public void sumar(Long quantity){
        this.productNumber = this.productNumber + quantity;
    }

    public double getTotalPrice() {
        return this.productNumber * this.pokemon.getPrice();
    }
}
