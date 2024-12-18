package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Category;

import java.util.Collection;
import java.util.Optional;

public interface CategoryService {
    long count();
    void save(Category t);
    Collection<Category> findAll();
    Optional<Category> findById(Long id);
}
