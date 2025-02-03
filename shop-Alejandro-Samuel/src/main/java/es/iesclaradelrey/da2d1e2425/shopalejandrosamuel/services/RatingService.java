package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Rating;

import java.util.Collection;
import java.util.Optional;

public interface RatingService {
    long count();
    void save(Rating t);
    Collection<Rating> findAll();
    Optional<Rating> findById(Long id);
    Collection<Rating> findByPokemon_Id(Long pokemonId);
//    Collection<Rating> findRatingsByPokemon_Region_Id(Long regionId);
}
