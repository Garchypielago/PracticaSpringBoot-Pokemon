package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.controllers;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.categories.Category;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.products.Pokemon;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.CategoryService;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.PokemonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.Optional;

@Controller
@RequestMapping({"/shop"})
public class ShopController {

    private final CategoryService categoryService;
    private final PokemonService pokemonService;

    public ShopController(CategoryService categoryService, PokemonService pokemonService) {
        this.categoryService = categoryService;
        this.pokemonService = pokemonService;
    }


    @GetMapping
    public String home() {
        return "redirect:/shop/category/1";
    }

    @GetMapping("/category/{id}")
    public ModelAndView getAllCategories(@PathVariable int id) {
        Collection<Category> categories = categoryService.findAll();
        Optional<Category> category = categoryService.findById((long) id);
        Collection<Pokemon> pokemones = pokemonService.findByCategory(category);
        System.out.println(category);
        System.out.println(pokemones);
//        System.out.println(categories);
        ModelAndView modelAndView = new ModelAndView("shop", "categories", categories);
        modelAndView.addObject("pokemones", pokemones);

        return modelAndView;
    }


}