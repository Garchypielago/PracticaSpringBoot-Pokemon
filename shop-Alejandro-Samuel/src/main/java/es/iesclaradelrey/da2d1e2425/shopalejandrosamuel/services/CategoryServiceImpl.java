package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.categories.Category;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.generic.CategoryRespository;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.generic.CategoryRespositoryImpl;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRespository categoryRespository ;

    public CategoryServiceImpl(CategoryRespository categoryRespository ) {
        this.categoryRespository = categoryRespository;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void save(Category t) {

    }

    @Override
    public Collection<Category> findAll() {
        return List.of();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return Optional.empty();
    }
}
