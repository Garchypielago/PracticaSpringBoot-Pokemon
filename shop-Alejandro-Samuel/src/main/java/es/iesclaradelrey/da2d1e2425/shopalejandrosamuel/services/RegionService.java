package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Region;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.Optional;

public interface RegionService {
    Collection<Region> findAll();
    Optional<Region> findById(Long id);
    Region save(Region region);

    void deleteById(Long id);
    Page<Region> findAll(Integer pageNumber, Integer pageSize, String orderBy, String orderDir);
}
