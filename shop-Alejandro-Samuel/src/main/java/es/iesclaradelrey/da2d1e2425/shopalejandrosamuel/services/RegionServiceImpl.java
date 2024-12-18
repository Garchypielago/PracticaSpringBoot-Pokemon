package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Region;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class RegionServiceImpl implements RegionService {
    private final RegionRepository regionRepository;

    public RegionServiceImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public Collection<Region> findAll() {
        return regionRepository.findAll();
    }

    @Override
    public Optional<Region> findById(int id) {
        return regionRepository.findById(id);
    }

    @Override
    public Region save(Region region) {
        return regionRepository.save(region);
    }
}
