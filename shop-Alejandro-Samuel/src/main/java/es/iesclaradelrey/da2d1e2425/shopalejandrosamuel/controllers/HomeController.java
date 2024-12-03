package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/",""})
public class HomeController {

    @GetMapping
    public String indexPage() {
        return "index.html";
    }

    @GetMapping
    @RequestMapping("/shop")
    public String shopPage() {
        return "shop.html";
    }

    @GetMapping
    @RequestMapping("/checkout")
    public String checkoutPage() {
        return "checkout.html";
    }

    @GetMapping
    @RequestMapping("/product-details")
    public String productDetailsPage() {
        return "product-details.html";
    }

    @GetMapping
    @RequestMapping("/cart")
    public String cartPage() {
        return "cart.html";
    }


}
