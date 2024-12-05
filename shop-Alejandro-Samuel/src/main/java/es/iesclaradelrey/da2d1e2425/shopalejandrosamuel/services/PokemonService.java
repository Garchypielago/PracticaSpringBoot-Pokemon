package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.categories.Category;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.products.Pokemon;

import java.util.Collection;
import java.util.Optional;

public interface PokemonService {
    long count();
    void save(Pokemon t);
    Collection<Pokemon> findAll();
    Optional<Pokemon> findById(Long id);
    Collection<Pokemon> findByCategory(Optional<Category> category);


}
