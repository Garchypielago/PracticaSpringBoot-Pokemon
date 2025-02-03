package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Pokemon;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.ProductInCart;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.ProductInCartRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ProductInCartServiceImpl implements ProductInCartService {
    private final ProductInCartRepository productInCartRepository;
    private final PokemonService pokemonService;

    public ProductInCartServiceImpl(ProductInCartRepository productInCartRepository, PokemonService pokemonService) {
        this.productInCartRepository = productInCartRepository;
        this.pokemonService = pokemonService;
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
        productInCartRepository.delete(productInCart);
    }

    @Override
    public Optional<ProductInCart> findByPokemon(Long pokemonId){
        return productInCartRepository.findByPokemon_Id(pokemonId);
    }
    @Override
    public void deleteAll(){
        productInCartRepository.deleteAll(findAll());

    }

    @Override
    public void createOrUpdateProductInCart(Long pokemonId, int quantity){
        ProductInCart productInCart = this.findByPokemon(pokemonId).orElse(null);

        if(productInCart == null){
            ProductInCart pc = new ProductInCart(pokemonService.findById(pokemonId).orElse(null), 1);
            this.save(pc);
        } else {
            productInCart.sumar();
            this.save(productInCart);
        }
    }

}
