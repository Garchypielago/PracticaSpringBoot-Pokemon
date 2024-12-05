package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.categories.Category;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.generic.CategoryRespository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRespository categoryRespository ;

    public CategoryServiceImpl(CategoryRespository categoryRespository ) {
        this.categoryRespository = categoryRespository;
    }

    @Override
    public long count() {
       return categoryRespository.count();
    }

    @Override
    public void save(Category t) {
        categoryRespository.save(t);
    }

    @Override
    public Collection<Category> findAll() {
        return categoryRespository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
       return categoryRespository.findById(id);
    }
}
