package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Pokemon;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    Collection<Rating> findByPokemon_Id(Long pokemonId);

    void deleteByPokemon_Id(Long id);

    void deleteByPokemon_Region_Id(Long pokemonRegionId);

    void deleteByPokemon(Pokemon pokemon);

    void deleteByPokemon_Type1_Id(Long pokemonType1Id);

    void deleteByPokemon_Type1_IdOrPokemon_Type2_Id(Long pokemonType1Id, Long pokemonType2Id);
//    Collection<Rating> findRatingsByPokemon_Region_Id(Long regionId);
}
