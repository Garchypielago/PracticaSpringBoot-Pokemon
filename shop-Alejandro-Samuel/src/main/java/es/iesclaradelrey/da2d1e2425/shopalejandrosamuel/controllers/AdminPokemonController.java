package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.controllers;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.CreatePokemonDTO;
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
public class AdminPokemonController {
    private final PokemonService pokemonService;
    private final RegionService regionService;
    private final TypeService typeService;

    public AdminPokemonController(PokemonService pokemonService, RegionService regionService, TypeService typeService) {
        this.pokemonService = pokemonService;
        this.regionService = regionService;
        this.typeService = typeService;
    }

    @GetMapping("/new")
    public ModelAndView newPokemonAdmin() {
        ModelAndView modelAndView = new ModelAndView("administration/pokemons/new");
        modelAndView.addObject("pokemon", new CreatePokemonDTO());
        modelAndView.addObject("regions", regionService.findAll());
        modelAndView.addObject("pokemons", pokemonService.findAll());
        modelAndView.addObject("types", typeService.findAll());

        return modelAndView;
    }

    @PostMapping("/new")
    public ModelAndView newPokemonAdmin(@ModelAttribute CreatePokemonDTO pokemonDTO) {
        pokemonService.saveFromDTO(pokemonDTO);
        ModelAndView modelAndView = new ModelAndView("administration/pokemons/new");
        modelAndView.addObject("regions", regionService.findAll());
        modelAndView.addObject("pokemons", pokemonService.findAll());
        modelAndView.addObject("types", typeService.findAll());
        modelAndView.addObject("pokemon", pokemonDTO);

        return modelAndView;
    }

}
