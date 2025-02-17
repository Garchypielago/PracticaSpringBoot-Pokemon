package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.ProductInCart;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductInCartRepository extends JpaRepository<ProductInCart, Long> {
    Optional<ProductInCart> findProductInCartByPokemon_Id(Long pokemonId);

}
