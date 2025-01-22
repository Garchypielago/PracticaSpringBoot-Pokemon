package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.controllers;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Pokemon;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.PokemonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping({"/","","/index"})
public class HomeController extends BaseController{

    private final PokemonService pokemonService;

    public HomeController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

//    @GetMapping
//    public String home() {
//        return "redirect:/index";
//    }

    @GetMapping
    public ModelAndView indexPage() {

        Collection<Pokemon> pokemonesHome = getRandomPokemones(9);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("pokemonesHome", pokemonesHome);

        return modelAndView;
    }

    @GetMapping
    @RequestMapping("/checkout")
    public String checkoutPage() {
        return "checkout";
    }

//    @GetMapping
//    @RequestMapping("/product-details")
//    public String productDetailsPage() {
//        return "product-details";
//    }

    @GetMapping
    @RequestMapping("/cart")
    public String cartPage() {
        return "cart";
    }

    public Collection<Pokemon> getRandomPokemones(int count) {
        Random random = new Random();
        Set<Long> randomIds = new HashSet<>();

        // Generar `count` números aleatorios únicos entre 1 y 1025, convertidos a Long
        while (randomIds.size() < count) {
            long randomId = (long) (random.nextInt(1025) + 1);
            randomIds.add(randomId);
        }

        // Buscar los Pokémon por los IDs generados y filtrar los que no se encuentren
        return randomIds.stream()
                .map(pokemonService::findById)
                .filter(Optional::isPresent) // Filtrar los Optional que están presentes
                .map(Optional::get) // Obtener el valor de los Optional presentes
                .collect(Collectors.toList());
    }




}
