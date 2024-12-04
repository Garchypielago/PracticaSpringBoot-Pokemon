package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.commandlinerunners;


import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.categories.Category;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.base.RepositoryImpl;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CategoryRepoCommandLineRunner implements CommandLineRunner {

    private final CategoryService categoryService;

    public CategoryRepoCommandLineRunner(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.save(new Category((long)1, "A","si"));
        categoryService.save(new Category((long) 2, "B","no"));
    }
}
