package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.controllers;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Pokemon;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.PokemonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping({"/","","/index"})
public class HomeController extends BaseController{

    public HomeController(PokemonService pokemonService) {
        super(pokemonService);
    }

    @GetMapping
    public ModelAndView indexPage() {

        Collection<Pokemon> pokemones = getRandomPokemones(9);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("pokemones", pokemones);

        return modelAndView;
    }

    @GetMapping
    @RequestMapping("/checkout")
    public String checkoutPage() {
        return "checkout";
    }


    @GetMapping
    @RequestMapping("/login")
    public String loginPage() {
        return "login";
    }



}
