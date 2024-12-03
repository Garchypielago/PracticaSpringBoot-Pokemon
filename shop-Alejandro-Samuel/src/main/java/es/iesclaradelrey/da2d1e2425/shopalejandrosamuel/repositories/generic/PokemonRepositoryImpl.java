package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.generic;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.products.Pokemon;
import org.springframework.stereotype.Repository;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.base.RepositoryImpl;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
@Repository
public class PokemonRepositoryImpl extends RepositoryImpl<Pokemon,Long> implements PokemonRepository{
    @Override
    public long count() {
        return 0;
    }

    @Override
    public void save(Pokemon pokemon) {

    }

    @Override
    public Collection<Pokemon> findAll() {
        return List.of();
    }

    @Override
    public Optional<Pokemon> findById(Long aLong) {
        return Optional.empty();
    }
}
