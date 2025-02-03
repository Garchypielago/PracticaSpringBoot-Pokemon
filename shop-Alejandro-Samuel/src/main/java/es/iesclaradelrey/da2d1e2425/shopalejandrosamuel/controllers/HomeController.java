package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.controllers;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Pokemon;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.ProductInCart;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.PokemonService;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.ProductInCartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping({"/","","/index"})
public class HomeController extends BaseController{

    private final PokemonService pokemonService;
    private final ProductInCartService productInCartService;

    public HomeController(PokemonService pokemonService, ProductInCartService productInCartService) {
        super(pokemonService);
        this.pokemonService = pokemonService;
        this.productInCartService = productInCartService;
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
    @RequestMapping("/addtocart/{id}")
    public String addToCart(@PathVariable Long id) {
        productInCartService.createOrUpdateProductInCart(id, 1);

        return "redirect:/product-details/pokemon/"+id;
    }
    @GetMapping
    @RequestMapping("/deletefromcart/{id}")
    public String deleteFromCart(@PathVariable Long id) {
        productInCartService.delete(productInCartService.findById(id).orElse(null));

        return "redirect:/cart";
    }
    @GetMapping
    @RequestMapping("/deleteAll")
    public String deleteAll() {
        productInCartService.deleteAll();

        return "redirect:/cart";
    }


}
