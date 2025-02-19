package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Pokemon;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.ProductInCart;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.exceptions.PokemonDontExist;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.exceptions.PokemonNoQuantityAvalaible;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.PokemonRepository;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.ProductInCartRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ProductInCartServiceImpl implements ProductInCartService {
    private final ProductInCartRepository productInCartRepository;
    private final PokemonRepository pokemonRepository;

    public ProductInCartServiceImpl(ProductInCartRepository productInCartRepository, PokemonRepository pokemonRepository) {
        this.productInCartRepository = productInCartRepository;
        this.pokemonRepository = pokemonRepository;
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
    public void delete(Long pokemonId) {
        productInCartRepository.delete(productInCartRepository
                .findProductInCartByPokemon_Id(pokemonId)
                .orElseThrow(() -> new PokemonDontExist("No existe producto con código "+ pokemonId)));
    }

    @Override
    public Optional<ProductInCart> findByPokemon(Long pokemonId){
        return productInCartRepository.findProductInCartByPokemon_Id(pokemonId);
    }
    @Override
    public void deleteAll(){
        productInCartRepository.deleteAll(findAll());
    }

    @Override
    public void createOrUpdateProductInCart(Long pokemonId, Long quantity){
        Pokemon pokemon = pokemonRepository
                .findById(pokemonId)
                .orElseThrow(() -> new PokemonDontExist("No existe producto con código "+ pokemonId));

        ProductInCart productInCart = productInCartRepository
                .findProductInCartByPokemon_Id(pokemonId)
                .orElse( new ProductInCart(pokemon, 0L));

        productInCart.sumar(quantity);
        if (productInCart.getProductNumber()>pokemon.getStock())
            throw new PokemonNoQuantityAvalaible(String.format("No hay suficientes unidades. Sólo hay "+ pokemon.getStock() +" en stock."));

        this.save(productInCart);
    }

    @Override
    public long getQuantityByPokemonId(Long pokemonId) {
        if(productInCartRepository.findProductInCartByPokemon_Id(pokemonId).isPresent())
            return productInCartRepository.findById(pokemonId).get().getProductNumber();

        return 0;
    }

}
