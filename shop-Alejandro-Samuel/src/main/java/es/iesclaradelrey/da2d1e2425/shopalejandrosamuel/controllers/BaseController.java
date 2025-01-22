package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.controllers;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Pokemon;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.PokemonService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class BaseController {

    private final PokemonService pokemonService;

    public BaseController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }


    @ModelAttribute(name="activeSection")
    public String addUrl(HttpServletRequest request) {
        String url = request.getRequestURI();
        System.out.println(url);
        return url.equals("/") ? "index" : url.split("/")[1];
    }

    public Collection<Pokemon> getRandomPokemones(int count) {
        Random random = new Random();
        Set<Long> randomIds = new HashSet<>();

        // Generar `count` números aleatorios únicos entre 1 y 1025, convertidos a Long
        while (randomIds.size() < count) {
            long randomId = (long) (random.nextInt(1025) + 1);
            randomIds.add(randomId);
        }

        // Buscar los Pokémon por los IDs generados y filtrar los que no se encuentren
        return randomIds.stream()
                .map(pokemonService::findById)
                .filter(Optional::isPresent) // Filtrar los Optional que están presentes
                .map(Optional::get) // Obtener el valor de los Optional presentes
                .collect(Collectors.toList());
    }


}
