package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.controllers;

import com.fasterxml.jackson.databind.node.ArrayNode;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Pokemon;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.PokemonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping({"/product-details",})
public class ProductController {
    private final PokemonService pokemonService;
    public ProductController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }
    @GetMapping
    public String home() {
        return "redirect:/product-details/pokemon/1";
    }
    @GetMapping("/pokemon/{id}")
    public ModelAndView category(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("product-details");
        Pokemon pokemon = pokemonService.findById(id).orElse(null);
        if (pokemon == null) {
            Pokemon pokemon1 = pokemonService.findById(1L).orElse(null);
            modelAndView.addObject("pokemon", pokemon1);
        }
        else {
            modelAndView.addObject("pokemon", pokemon);
        }
        return modelAndView;
    }

}
