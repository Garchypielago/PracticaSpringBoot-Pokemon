package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    Collection<Pokemon> findByRegion_Id(int region);
    Collection<Pokemon> findPokemonByType1_IdOrType2_Id(int type1_id, int type2_id);

}
