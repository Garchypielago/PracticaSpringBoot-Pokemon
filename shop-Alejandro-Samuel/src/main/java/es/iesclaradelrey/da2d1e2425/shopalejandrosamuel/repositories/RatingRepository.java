package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

    Collection<Rating> findByPokemon_Id(Long pokemonId);
}
