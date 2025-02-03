package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Rating;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {
    private RatingRepository ratingRepository;

    public RatingServiceImpl(RatingRepository ratingRepository) {this.ratingRepository = ratingRepository;}

    @Override
    public long count() {return this.ratingRepository.count();}

    @Override
    public void save(Rating t) {ratingRepository.save(t);}

    @Override
    public Collection<Rating> findAll() {
        return this.ratingRepository.findAll();
    }

    @Override
    public Optional<Rating> findById(Long id) {
        return this.ratingRepository.findById(id);
    }

    @Override
    public Collection<Rating> findByPokemon_Id(Long pokemonId) {
        return this.ratingRepository.findByPokemon_Id(pokemonId);
    }

//    @Override
//    public Collection<Rating> findRatingsByPokemon_Region_Id(Long regionId) {
//        return this.ratingRepository.findRatingsByPokemon_Region_Id(regionId);
//    }
}
