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
    public Optional<ProductInCart> findById(Long id) {return productInCartRepository.findById((long) id);
    }

    @Override
    public ProductInCart save(ProductInCart productInCart) {
        return productInCartRepository.save(productInCart);
    }

    @Override
    public void delete(ProductInCart productInCart) {

    }

    @Override
    public Optional<ProductInCart> findByPokemon(Long pokemonId){
        return productInCartRepository.findByPokemon_Id(pokemonId);
    }

}
