package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services;


import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.ProductInCart;

import java.util.Collection;

public interface ProductInCartService {
    Collection<ProductInCart> findAll();
    ProductInCart findById(int id);
    ProductInCart save(ProductInCart productInCart);
}
