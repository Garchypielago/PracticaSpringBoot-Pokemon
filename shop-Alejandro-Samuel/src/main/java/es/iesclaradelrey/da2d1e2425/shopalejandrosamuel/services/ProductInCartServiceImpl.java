package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.ProductInCart;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.ProductInCartRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ProductInCartServiceImpl implements ProductInCartService {
    private final ProductInCartRepository productInCartRepository;

    public ProductInCartServiceImpl(ProductInCartRepository productInCartRepository) {
        this.productInCartRepository = productInCartRepository;
    }

    @Override
    public Collection<ProductInCart> findAll() {
        return productInCartRepository.findAll();
    }

    @Override
    public Optional<ProductInCart> findById(int id) {return productInCartRepository.findById((long) id);
    }

    @Override
    public ProductInCart save(ProductInCart productInCart) {
        return null;
    }

    @Override
    public void delete(ProductInCart productInCart) {

    }

}
