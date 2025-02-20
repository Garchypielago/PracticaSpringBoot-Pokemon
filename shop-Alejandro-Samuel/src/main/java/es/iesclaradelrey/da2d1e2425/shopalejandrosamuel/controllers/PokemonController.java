package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.controllers;


import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.CreatePokemonDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Pokemon;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.PokemonService;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.RegionService;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/pokemons")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(TypeService typeService, RegionService regionService, PokemonService pokemonService) {

        this.pokemonService = pokemonService;
    }

    @GetMapping("/new")
    public ModelAndView newPokemon() {
        ModelAndView modelAndView = new ModelAndView("administration/pokemons/new");
        modelAndView.addObject("pokemon", new CreatePokemonDTO());
        return modelAndView;
    }

    @PostMapping("/new")
    public ModelAndView newPokemon(@ModelAttribute CreatePokemonDTO pokemonDTO) {
        pokemonService.save(new Pokemon());
        return new ModelAndView("administration/pokemons/new", "pokemon", pokemonDTO);
    }


}
