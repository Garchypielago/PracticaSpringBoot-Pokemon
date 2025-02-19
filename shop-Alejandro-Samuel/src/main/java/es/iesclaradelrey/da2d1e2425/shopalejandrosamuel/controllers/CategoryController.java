package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.controllers;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.CreateCategoryDto;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Region;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Type;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.RegionService;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {

    private final TypeService typeService;
    private final RegionService regionService;

    public CategoryController(TypeService typeService, RegionService regionService) {
        this.typeService = typeService;
        this.regionService = regionService;
    }

    @GetMapping("/new")
    public ModelAndView newCategory() {
        ModelAndView modelAndView = new ModelAndView("administration/categories/new");
        modelAndView.addObject("category", new CreateCategoryDto());
        return modelAndView;
    }

    @PostMapping("/new")
    public ModelAndView newCategory(@ModelAttribute CreateCategoryDto categoryDto) {
        if (categoryDto.getCategoryType() == 1)
            regionService.save(new Region(categoryDto.getName()));

        if (categoryDto.getCategoryType() == 2)
            typeService.save(new Type(categoryDto.getName()));

        return new ModelAndView("administration/categories/new", "category", categoryDto);
    }


}
