package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.CreateEditTypeDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Type;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.Optional;

public interface TypeService {
    Collection<Type> findAll();
    Optional<Type> findById(Long id);
    Type save(Type type);

    Page<Type> findAll(Integer pageNumber, Integer pageSize, String orderBy, String orderDir);

    void deleteById(Long id);
    public void editFromDTO(CreateEditTypeDTO editTypeDTO);
}
