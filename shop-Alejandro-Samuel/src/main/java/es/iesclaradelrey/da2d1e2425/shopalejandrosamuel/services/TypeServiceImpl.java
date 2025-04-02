package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.AppTypeDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.CreateEditTypeDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Type;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.exceptions.PokemonDontExist;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.PokemonRepository;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.RatingRepository;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.RegionRepository;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.TypeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class TypeServiceImpl implements TypeService {
    private final TypeRepository typeRepository;
    private final PokemonRepository pokemonRepository;
    private final RatingRepository ratingRepository;

    public TypeServiceImpl(TypeRepository typeRepository, PokemonRepository pokemonRepository, RegionRepository regionRepository, RatingRepository ratingRepository) {
        this.typeRepository = typeRepository;
        this.pokemonRepository = pokemonRepository;
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Collection<Type> findAll() {
        return typeRepository.findAll();
    }

    @Override
    public Optional<Type> findById(Long id) {
        return typeRepository.findById(id);
    }

    @Override
    public Type save(Type type) {
        return typeRepository.save(type);
    }

    public Page<Type> findAll(Integer pageNumber, Integer pageSize, String orderBy, String orderDir) {
        Sort.Direction direction = orderDir.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        PageRequest pageRequest = PageRequest.of(pageNumber-1, pageSize, Sort.by(direction, orderBy));

        return typeRepository.findAll(pageRequest);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
            ratingRepository.deleteByPokemon_Type1_IdOrPokemon_Type2_Id(id, id);
            pokemonRepository.deleteByType1_IdOrType2_Id(id, id);

        typeRepository.delete(typeRepository.findById(id).orElseThrow(
                () -> new PokemonDontExist("Region not found")
        ));
    }

    @Override
    public void editFromDTO(Long id, CreateEditTypeDTO editTypeDTO) {
        Type type = typeRepository.findById(id).orElseThrow(
                () -> new PokemonDontExist("Type not found")
        );

        type.setName(editTypeDTO.getName());
        type.setBackground(editTypeDTO.getBackground());

        typeRepository.save(type);
    }


    @Override
    public List<AppTypeDTO> findAllDTO(){
        return typeRepository.findAllDTO().stream().toList();
    }
}
