package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.commandlinerunners;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Pokemon;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.PokemonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Order(2)
public class PokemonRepoCommandLineRunner implements CommandLineRunner {
    private final PokemonService pokemonService;

    public PokemonRepoCommandLineRunner(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        pokemonService.findAll().forEach(pokemon -> {pokemon.setPrice(pokemon.calcPrice());});
    }

//    public PokemonRepoCommandLineRunner(PokemonService pokemonService) {
//        this.pokemonService = pokemonService;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        pokemonService.save(new Pokemon((long)1, "Charmander"));
//        pokemonService.save(new Pokemon((long)2, "Bulbasaur"));
//        pokemonService.save(new Pokemon((long)3, "Squirtle"));
//        pokemonService.save(new Pokemon((long)4, "hola"));
//        pokemonService.save(new Pokemon((long)5, "Adios"));
//        pokemonService.save(new Pokemon((long)6, "sioque"));
//    }
}

