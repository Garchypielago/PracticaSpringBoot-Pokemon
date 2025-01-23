package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.controllers;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.ProductInCart;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.ProductInCartRepository;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.ProductInCartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
@RequestMapping({"/cart","/cart/"})
public class CartController {
    private final ProductInCartService productInCartService;
    public CartController(ProductInCartService productInCartService){
        this.productInCartService = productInCartService;
    }
 @GetMapping
 public ModelAndView cartPage() {
        Collection<ProductInCart> productInCarts = productInCartService.findAll();
     ModelAndView mv = new ModelAndView("cart");
     mv.addObject("productInCarts", productInCarts);
     return mv;

 }
}
