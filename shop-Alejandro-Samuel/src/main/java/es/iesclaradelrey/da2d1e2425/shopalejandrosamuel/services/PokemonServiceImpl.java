package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Pokemon;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.exceptions.PokemonDontExist;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.exceptions.PokemonNoQuantityAvalaible;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.PokemonRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PokemonServiceImpl implements PokemonService {
    private final PokemonRepository pokemonRepository;

    public PokemonServiceImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public long count() {
        return pokemonRepository.count();
    }

    @Override
    public void save(Pokemon t) {
        pokemonRepository.save(t);
    }

    @Override
    public Collection<Pokemon> findAll() {
        return pokemonRepository.findAll();
    }

    @Override
    public Optional<Pokemon> findById(Long id) {
        return pokemonRepository.findById(id);
    }

    public Collection<Pokemon> findByRegion(Long regId){
        return pokemonRepository.findByRegion_Id(regId);
    }
    public Collection<Pokemon> findByType(Long typeId){
        return pokemonRepository.findPokemonByType1_IdOrType2_Id(typeId, typeId);
    }

    @Override
    public Double avgRatingsFromPokemon(Long pokemon_id) {
        return pokemonRepository.avgRatingsFromPokemon(pokemon_id);
    }

    @Override
    public void existsById(Long pokemon_id) {
        if (pokemonRepository.findById(pokemon_id).isEmpty()){
            throw new PokemonDontExist(String.format("No existe producto con código "+ pokemon_id));
        }
    }

    @Override
    public void quantityAvalaible(Long pokemon_id, Long quantityCart) {
        long newQuantity = pokemonRepository.findById(pokemon_id).get().getStock() - quantityCart;
        if(newQuantity < 0){
//            pokemonRepository.findById(pokemon_id).get().setStock(newQuantity);
            //        productInCartService.createOrUpdateProductInCart(id, 1);

            throw new PokemonNoQuantityAvalaible(String.format("No hay suficientes unidades. Sólo hay "+
                    pokemonRepository.findById(pokemon_id).get().getStock() +" en stock."));
        }
    }
}
