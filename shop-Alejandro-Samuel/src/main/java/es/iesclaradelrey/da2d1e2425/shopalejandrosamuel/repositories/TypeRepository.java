package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.AppTypeDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface TypeRepository extends JpaRepository<Type, Long> {

    @Query(value = "SELECT new es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.AppTypeDTO(t.id, t.name, t.background) FROM Type t")
    Collection<AppTypeDTO> findAllDTO();
}
