package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.CreateEditRegionDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Region;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.exceptions.PokemonDontExist;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.PokemonRepository;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.RatingRepository;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.RegionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
public class RegionServiceImpl implements RegionService {
    private final RegionRepository regionRepository;
    private final PokemonRepository pokemonRepository;
    private final RatingRepository ratingRepository;

    public RegionServiceImpl(RegionRepository regionRepository, PokemonRepository pokemonRepository, RatingRepository ratingRepository) {
        this.regionRepository = regionRepository;
        this.pokemonRepository = pokemonRepository;
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Collection<Region> findAll() {
        return regionRepository.findAll();
    }

    @Override
    public Optional<Region> findById(Long id) {
        return regionRepository.findById(id);
    }

    @Override
    public Region save(Region region) {
        return regionRepository.save(region);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        ratingRepository.deleteByPokemon_Region_Id(id);
        pokemonRepository.deleteByRegion_Id(id);

        regionRepository.delete(regionRepository.findById(id).orElseThrow(
                () -> new PokemonDontExist("Region not found")
        ));
    }

    @Override
    public Page<Region> findAll(Integer pageNumber, Integer pageSize, String orderBy, String orderDir) {
        Sort.Direction direction = orderDir.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        PageRequest pageRequest = PageRequest.of(pageNumber-1, pageSize, Sort.by(direction, orderBy));

        return regionRepository.findAll(pageRequest);
    }

    @Override
    public void editFromDTO(CreateEditRegionDTO regionDTO) {
        Region region = regionRepository.findById(regionDTO.getId()).orElseThrow(
                () -> new PokemonDontExist("region not found")
        );

        region.setName(regionDTO.getName());

        regionRepository.save(region);
    }
}
