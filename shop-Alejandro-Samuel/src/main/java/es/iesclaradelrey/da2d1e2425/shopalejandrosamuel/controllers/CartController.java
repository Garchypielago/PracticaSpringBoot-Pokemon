package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.controllers;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.ProductInCart;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.AuthService;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.PokemonService;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.ProductInCartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
@RequestMapping({"/cart"})
public class CartController extends BaseController {

    private final ProductInCartService productInCartService;
    private final AuthService authService;

    public CartController(PokemonService pokemonService, ProductInCartService productInCartService, AuthService authService) {
        super(pokemonService);
        this.productInCartService = productInCartService;
        this.authService = authService;
    }

    @GetMapping
    public ModelAndView cartPage() {
        Collection<ProductInCart> productInCarts = productInCartService.findByUserId(authService.getCurrentAppUserId());

        ModelAndView mv = new ModelAndView("cart");
        mv.addObject("products", productInCarts);
        return mv;
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
