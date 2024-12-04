package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.controllers;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.categories.Category;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
@RequestMapping({"/shop"})
public class ShopController {

    private final CategoryService categoryService;

    public ShopController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping
    public String home() {
        return "redirect:/shop/category/1";
    }

    @GetMapping("/category/{id}")
    public ModelAndView getAllCategories(@PathVariable int id) {
        Collection<Category> categories = categoryService.findAll();
//        System.out.println(categories);
        return new ModelAndView("shop", "categories", categories);
    }


}