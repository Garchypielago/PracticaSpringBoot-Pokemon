package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.generic;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.categories.Category;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.products.Pokemon;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.base.RepositoryImpl;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRespositoryImpl  extends RepositoryImpl<Category,Long> implements CategoryRespository {
    @Override
    public long count() {
        return 0;
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public Collection<Category> findAll() {
        return List.of();
    }

    @Override
    public Optional<Category> findById(Long aLong) {
        return Optional.empty();
    }

}
