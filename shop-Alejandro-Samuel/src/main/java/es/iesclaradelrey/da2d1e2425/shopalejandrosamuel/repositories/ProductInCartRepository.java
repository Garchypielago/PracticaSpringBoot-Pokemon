package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.AppProductInCartDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.ProductInCart;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.Optional;

public interface ProductInCartRepository extends JpaRepository<ProductInCart, Long> {
    Optional<ProductInCart> findProductInCartByPokemon_Id(Long pokemonId);


    @Query(value = "SELECT new es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.AppProductInCartDTO(p.id, p.pokemon, p.productNumber) FROM ProductInCart p")
    Collection<AppProductInCartDTO> findAllDTO();
}
