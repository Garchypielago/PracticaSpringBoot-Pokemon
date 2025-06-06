package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Rating;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {
    private final RatingRepository ratingRepository;

    public RatingServiceImpl(RatingRepository ratingRepository, PokemonService pokemonService) {this.ratingRepository = ratingRepository;
    }

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

    @Override
    public void deleteByPokemonId(Long pokemonId) {
//        this.ratingRepository.deleteAll(this.ratingRepository.findByPokemon_Id(pokemonId));

        for (Rating rating : this.ratingRepository.findByPokemon_Id(pokemonId)) {
            this.ratingRepository.delete(rating);
        }
//        ratingRepository.delete(findByPokemon_Id(pokemonId))
    }
}
