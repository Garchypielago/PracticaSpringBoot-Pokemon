package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.AppRegionDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Long> {

    @Query(value = "SELECT new es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.AppRegionDTO(r.id, r.name) FROM Region r")
    Collection<AppRegionDTO> findAllDTO();

}
