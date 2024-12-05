package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.generic;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.categories.Category;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.products.Pokemon;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.base.Repository;

import java.util.Collection;
import java.util.Optional;

public interface PokemonRepository extends Repository<Pokemon, Long> {

    Collection<Pokemon> findByCategory(Optional<Category> category);
}
