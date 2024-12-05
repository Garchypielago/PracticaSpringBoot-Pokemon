package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.commandlinerunners;


import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.categories.Category;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.enums.Regions;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.enums.Types;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class CategoryRepoCommandLineRunner implements CommandLineRunner {

    private final CategoryService categoryService;

    public CategoryRepoCommandLineRunner(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.save(new Category((long)1, "Kanto", Regions.KANTO));
        categoryService.save(new Category((long) 2, "Johto",Regions.JOHTO));
        categoryService.save(new Category((long) 3, "Hoenn",Regions.HOENN));
        categoryService.save(new Category((long)1, "FIRE", Types.FIRE, "/shopedex/fondofuego.jpg"));
        categoryService.save(new Category((long) 2, "WATER", Types.WATER, "/shopedex/fondoarbol.jpg"));
        categoryService.save(new Category((long) 3, "GRASS", Types.GRASS, "/shopedex/fondomar.jpg"));
    }
}
