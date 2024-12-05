package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.commandlinerunners;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.products.Pokemon;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.CategoryService;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.PokemonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class PokemonRepoCommandLineRunner implements CommandLineRunner {
    private final PokemonService pokemonService;
    private final CategoryService categoryService;

    public PokemonRepoCommandLineRunner(PokemonService pokemonService, CategoryService categoryService) {
        this.pokemonService = pokemonService;
        this.categoryService = categoryService;
    }

//    public PokemonRepoCommandLineRunner(PokemonService pokemonService) {
//        this.pokemonService = pokemonService;
//    }

    @Override
    public void run(String... args) throws Exception {
        pokemonService.save(new Pokemon((long)1, "Charmander", categoryService.findById((long) 1)));
        pokemonService.save(new Pokemon((long)2, "Bulbasaur", categoryService.findById((long) 2)));
        pokemonService.save(new Pokemon((long)3, "Squirtle", categoryService.findById((long) 3)));
        pokemonService.save(new Pokemon((long)4, "Hola", categoryService.findById((long) 1)));
        pokemonService.save(new Pokemon((long)5, "Adios", categoryService.findById((long) 2)));
        pokemonService.save(new Pokemon((long)6, "sioque", categoryService.findById((long) 3)));
    }
}

