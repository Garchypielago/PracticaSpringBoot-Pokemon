package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Region;

import java.util.Collection;
import java.util.Optional;

public interface RegionService {
    Collection<Region> findAll();
    Optional<Region> findById(int id);
    Region save(Region region);
}
