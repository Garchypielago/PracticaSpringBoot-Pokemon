package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Type;

import java.util.Collection;
import java.util.Optional;

public interface TypeService {
    Collection<Type> findAll();
    Optional<Type> findById(Long id);
    Type save(Type type);
}
