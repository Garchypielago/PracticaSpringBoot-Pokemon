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
}
