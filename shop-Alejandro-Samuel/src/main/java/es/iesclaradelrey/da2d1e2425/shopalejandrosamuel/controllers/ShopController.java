package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.controllers;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Pokemon;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.PokemonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.Optional;

@Controller
@RequestMapping({"/shop"})
public class ShopController {

    private final PokemonService pokemonService;

    public ShopController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }


    @GetMapping
    public String home() {
        return "redirect:/shop/category/1";
    }

    @GetMapping("/category/{id}")
    public ModelAndView getAllCategories(@PathVariable int id) {

        Collection<Pokemon> pokemones = pokemonService.findByRegion(id);

        ModelAndView modelAndView = new ModelAndView("shop/category");
        return new ModelAndView("shop");
    }


}