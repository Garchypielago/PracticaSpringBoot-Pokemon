package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services;


import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.ProductInCart;

import java.util.Collection;
import java.util.Optional;

public interface ProductInCartService {
    Collection<ProductInCart> findAll();
    Optional<ProductInCart> findById(int id);
    ProductInCart save(ProductInCart productInCart);
    void delete(ProductInCart productInCart);
}
