package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.criteriaAPI.PokemonSpecification;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.AppPokemonDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.CreateEditPokemonDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.CreateNewPokemonDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Pokemon;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.StatValue;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.exceptions.PokemonDontExist;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.exceptions.PokemonDuplicated;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.PokemonRepository;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.RatingRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class PokemonServiceImpl implements PokemonService {
    private final PokemonRepository pokemonRepository;
    private final RatingRepository ratingRepository;

    public PokemonServiceImpl(PokemonRepository pokemonRepository, RatingRepository ratingRepository) {
        this.pokemonRepository = pokemonRepository;
        this.ratingRepository = ratingRepository;
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

    @Transactional
    @Override
    public void     deleteById(Long id) {
        ratingRepository.deleteByPokemon_Id(id);
        pokemonRepository.delete(pokemonRepository.findById(id).orElseThrow(
                () -> new PokemonDontExist("Pokemon not found")
        ));

    }

    @Override
    public void editFromDTO(CreateEditPokemonDTO pokemonDTO) {
        if (pokemonRepository.sameName(pokemonDTO.getId(),pokemonDTO.getName())>0){
            throw new PokemonDuplicated("Pokemon name is duplicated");
        }
        Pokemon pokemon = pokemonRepository.findById(pokemonDTO.getId()).orElseThrow(
                () -> new PokemonDontExist("Pokemon not found")
        );

                pokemon.setName(pokemonDTO.getName());
                pokemon.setDescription(pokemonDTO.getDescription());
                pokemon.setType1(pokemonDTO.getType1());
                pokemon.setType2(pokemonDTO.getType2());
                pokemon.setRegion( pokemonDTO.getRegion());
                pokemon.setLegendary(pokemonDTO.isLegendary());
                pokemon.setStock(pokemonDTO.getStock());
                pokemon.setPrice(pokemonDTO.getPrice());

        pokemonRepository.save(pokemon);
    }



    @Override
    public void saveFromDTO(CreateNewPokemonDTO pokemonDTO) {
        if (pokemonRepository.sameName(0L,pokemonDTO.getName())>0){
            throw new PokemonDuplicated("Pokemon name is duplicated");
        }
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

    @Override
    public Page<AppPokemonDTO> findByTypeId(Long typeId, Integer pageNumber, Integer pageSize, String orderBy, String orderDir){
    Sort.Direction direction = orderDir.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
    PageRequest pageRequest = PageRequest.of(pageNumber-1, pageSize, Sort.by(direction, orderBy));


    return pokemonRepository.findAllByType1_IdOrType2_Id(typeId, typeId, pageRequest);
    }

    @Override
    public Page<Pokemon> findWithCriteriaApi(String search, Long brandId, Long categoryId, String sortBy, String sortDirection, Integer pageNumber, Integer pageSize) {

        Sort.Direction direction = sortDirection.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);

        Pageable pageRequest = PageRequest.of(pageNumber, pageSize, sort);

        PokemonSpecification pokemonSpecification = new PokemonSpecification(search
//                , brandId, categoryId
        );


        return pokemonRepository.findAll(pokemonSpecification, pageRequest);
    }

}
