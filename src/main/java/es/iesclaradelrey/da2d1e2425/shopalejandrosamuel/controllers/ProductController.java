package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.controllers;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Pokemon;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Rating;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.PokemonService;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.RatingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
@RequestMapping({"/product-details",})
public class ProductController extends  BaseController{

    private final PokemonService pokemonService;
    private final RatingService ratingService;

    public ProductController(PokemonService pokemonService, RatingService ratingService) {
        super(pokemonService);
        this.pokemonService = pokemonService;
        this.ratingService = ratingService;
    }

    @GetMapping
    public String home() {
        return "redirect:/product-details/pokemon/1";
    }

    @GetMapping("/pokemon/{id}")
    public ModelAndView pokemon(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("product-details");
        Pokemon pokemon = pokemonService.findById(id).orElse(null);
        if (pokemon == null) {
            return new ModelAndView("redirect:/product-details/pokemon/1");
        }

        Collection<Pokemon> pokemones = getRandomPokemones(4);
        Collection<Rating> ratings = ratingService.findByPokemon_Id(id);

        modelAndView.addObject("pokemon", pokemon);
        modelAndView.addObject("pokemones", pokemones);
        modelAndView.addObject("ratings", ratings);
        modelAndView.addObject("pokemonRating", pokemonService.avgRatingsFromPokemon(id));

        return modelAndView;
    }

}
