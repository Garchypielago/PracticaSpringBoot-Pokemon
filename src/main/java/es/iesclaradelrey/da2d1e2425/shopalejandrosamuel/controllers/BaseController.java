package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.controllers;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Pokemon;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.PokemonService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
public class BaseController {

    private final PokemonService pokemonService;

    public BaseController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @ModelAttribute(name = "activeSection")
    public String addUrl(HttpServletRequest request) {
        String url = request.getRequestURI();
        return url.equals("/") ? "index" : url.split("/")[1];
    }

    public Collection<Pokemon> getRandomPokemones(int count) {
        List<Pokemon> pokemones = new ArrayList<>(pokemonService.findAll());
        Collections.shuffle(pokemones);
        return pokemones.stream()
                .limit(count)
                .toList();
    }
}
