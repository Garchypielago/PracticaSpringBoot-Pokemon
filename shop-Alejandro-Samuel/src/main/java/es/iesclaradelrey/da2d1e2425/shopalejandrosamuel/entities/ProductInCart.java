package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities;

import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "product_in_cart", nullable = false)
    private Pokemon pokemon;

    @Column
    private Long productNumber;

    @Column(columnDefinition = "timestamp default current_timestamp()", nullable = false, insertable = false, updatable = false )
    private LocalDateTime addedTime;
    @Column(columnDefinition = "timestamp default current_timestamp() on update current_timestamp()", nullable = false, insertable = false, updatable = false )
    private LocalDateTime modifiedTime;


    public ProductInCart(Pokemon pokemon, Long productNumber) {
        this.pokemon = pokemon;
        this.productNumber = productNumber;
    }

    public void sumar(Long quantity){
        this.productNumber = this.productNumber + quantity;
    }

}
