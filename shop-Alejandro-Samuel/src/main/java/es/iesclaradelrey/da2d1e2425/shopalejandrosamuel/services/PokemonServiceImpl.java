package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.CreatePokemonDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Pokemon;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.StatValue;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.exceptions.PokemonDontExist;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.PokemonRepository;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.StatValueRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PokemonServiceImpl implements PokemonService {
    private final PokemonRepository pokemonRepository;
    private final StatValueRepository statValueRepository;

    public PokemonServiceImpl(PokemonRepository pokemonRepository, StatValueRepository statValueRepository) {
        this.pokemonRepository = pokemonRepository;
        this.statValueRepository = statValueRepository;
    }

    @Override
    public long count() {
        return pokemonRepository.count();
    }

    @Override
    public void save(Pokemon t) {
        pokemonRepository.save(t);
    }

    @Override
    public Collection<Pokemon> findAll() {
        return pokemonRepository.findAll();
    }

    @Override
    public Optional<Pokemon> findById(Long id) {
        return pokemonRepository.findById(id);
    }

    public Collection<Pokemon> findByRegion(Long regId) {
        return pokemonRepository.findByRegion_Id(regId);
    }

    public Collection<Pokemon> findByType(Long typeId) {
        return pokemonRepository.findPokemonByType1_IdOrType2_Id(typeId, typeId);
    }

    @Override
    public Double avgRatingsFromPokemon(Long pokemon_id) {
        return pokemonRepository.avgRatingsFromPokemon(pokemon_id);
    }

    @Override
    public void saveFromDTO(CreatePokemonDTO pokemonDTO) {
        Pokemon pokeReference = pokemonRepository.findById(pokemonDTO.getIdReference()).orElseThrow(
                () -> new PokemonDontExist("Pokemon not found")
        );

        System.out.println(pokeReference.toString());

        System.out.println(pokemonDTO);

        Pokemon newPokemon = new Pokemon(pokemonRepository.findMaxId() + 1,
                pokemonDTO.getName(),
                pokemonDTO.getDescription(),
                pokemonDTO.getType1(),
                pokemonDTO.getType2(),
                pokemonDTO.getRegion(),
                pokemonDTO.isLegendary(),
                pokemonDTO.getStock()
        );

        Collection<StatValue> stats = pokeReference.getStats();

        newPokemon.setStats(
                stats.stream().map(stat -> new StatValue(newPokemon, stat.getStat(), stat.getStatValue())).toList());

        newPokemon.setPrice(newPokemon.calcPrice());
        pokemonRepository.save(newPokemon);
    }

    @Override
    public Page<Pokemon> findAll(Integer pageNumber, Integer pageSize, String orderBy, String orderDir) {
        Sort.Direction direction = orderDir.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        PageRequest pageRequest = PageRequest.of(pageNumber-1, pageSize, Sort.by(direction, orderBy));

        return pokemonRepository.findAll(pageRequest);
    }

}
