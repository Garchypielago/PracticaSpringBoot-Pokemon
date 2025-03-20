package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.CreateEditPokemonDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.CreateNewPokemonDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Pokemon;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.Optional;

public interface PokemonService {
    long count();
    void save(Pokemon t);
    Collection<Pokemon> findAll();
    Optional<Pokemon> findById(Long id);
    Collection<Pokemon> findByRegion(Long id);
    Collection<Pokemon> findByType(Long id);
    Double avgRatingsFromPokemon(Long pokemon_id);
    void deleteById(Long id);
    void saveFromDTO(CreateNewPokemonDTO pokemonDTO);
    public void editFromDTO(CreateEditPokemonDTO pokemonDTO);
    Page<Pokemon> findAll(Integer pageNumber, Integer pageSize, String orderBy, String orderDir);

}
