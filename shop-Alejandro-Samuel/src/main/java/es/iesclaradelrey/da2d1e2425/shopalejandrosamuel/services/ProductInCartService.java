package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services;


import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.AppProductInCartDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.ProductInCart;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ProductInCartService {
    Collection<ProductInCart> findAll();
    Optional<ProductInCart> findById(Long id);
    ProductInCart save(ProductInCart productInCart);
    void delete(ProductInCart productInCart);
    void delete(Long productId);
    void deleteAll();
    Optional<ProductInCart> findByPokemon(Long pokemonId);
    void createOrUpdateProductInCart(Long pokemonId, Long quantity);
    long getQuantityByPokemonId(Long pokemonId);

    List<AppProductInCartDTO> findAllDTO();

    Double getTotalPrice();


    Collection<ProductInCart> findByUserId(Long userId);

}
