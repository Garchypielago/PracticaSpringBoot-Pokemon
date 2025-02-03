package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.controllers;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Pokemon;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Region;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Type;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.PokemonRepository;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.PokemonService;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.RegionService;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.Optional;

@Controller
@RequestMapping({"/shop"})
public class ShopController extends  BaseController{

    private final PokemonService pokemonService;
    private final RegionService regionService;
    private final TypeService typeService;

    public ShopController(PokemonService pokemonService, RegionService regionService, TypeService typeService) {
        super(pokemonService);
        this.pokemonService = pokemonService;
        this.regionService = regionService;
        this.typeService = typeService;
    }


    @GetMapping
    public String home() {
        return "redirect:/shop/category/0";
    }

    @GetMapping("/category/{id}")
    public ModelAndView getAllCategories(@PathVariable Long id) {
        Collection<Pokemon> pokemones = null;
        ModelAndView modelAndView = new ModelAndView("shop");
        Collection<Region> regiones = regionService.findAll();

        if(id==0){
            pokemones = pokemonService.findAll();
        } else{
            pokemones = pokemonService.findByRegion(id);
        }

        modelAndView.addObject("regiones", regiones);
        Collection<Type> types = typeService.findAll();
        modelAndView.addObject("pokemones", pokemones);
        modelAndView.addObject("current", id);
        modelAndView.addObject("types", types);

        return modelAndView;
    }




}