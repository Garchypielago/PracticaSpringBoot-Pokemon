package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.generic;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.categories.Category;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.products.Pokemon;
import org.springframework.stereotype.Repository;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.base.RepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
@Repository
public class PokemonRepositoryImpl extends RepositoryImpl<Pokemon,Long> implements PokemonRepository{
    @Override
    public Collection<Pokemon> findByCategory(Optional<Category> category) {
        Collection<Pokemon> pokemones = findAll();
        ArrayList<Pokemon> pokemonesFinal = new ArrayList<Pokemon>();

        for(Pokemon pokemon : pokemones){
            if (pokemon.getRegion().equals(category)){
                pokemonesFinal.add(pokemon);
            }
        }

        return pokemonesFinal;
    }
}
