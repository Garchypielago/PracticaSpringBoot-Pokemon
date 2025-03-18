package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.controllers.admin;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.CreateCategoryDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Region;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Type;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.RegionService;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/categories")
public class AdminCategoryController {

    private final TypeService typeService;
    private final RegionService regionService;

    public AdminCategoryController(TypeService typeService, RegionService regionService) {
        this.typeService = typeService;
        this.regionService = regionService;
    }

    @GetMapping({"/region/list"})
    public ModelAndView categoryList(@RequestParam(defaultValue = "1") Integer pageNumber,
                                     @RequestParam(defaultValue = "10")Integer pageSize,
                                     @RequestParam(defaultValue = "id") String orderBy,
                                     @RequestParam(defaultValue = "asc")String orderDir){

        Map<String, String> options = new LinkedHashMap<String, String>();
        options.put("Id", "id");
        options.put("Name", "name");

        ModelAndView modelAndView = new ModelAndView("administration/categories/region/list");
        modelAndView.addObject("orderBy", orderBy);
        modelAndView.addObject("orderDir", orderDir);
        modelAndView.addObject("options", options);
        modelAndView.addObject("regions", regionService.findAll(pageNumber, pageSize, orderBy, orderDir));
        return modelAndView;
    }

    @GetMapping({"/type/list"})
    public ModelAndView typeList(@RequestParam(defaultValue = "1") Integer pageNumber,
                                     @RequestParam(defaultValue = "10")Integer pageSize,
                                     @RequestParam(defaultValue = "id") String orderBy,
                                     @RequestParam(defaultValue = "asc")String orderDir){

        Map<String, String> options = new LinkedHashMap<String, String>();
        options.put("Id", "id");
        options.put("Name", "name");

        ModelAndView modelAndView = new ModelAndView("administration/categories/type/list");
        modelAndView.addObject("orderBy", orderBy);
        modelAndView.addObject("orderDir", orderDir);
        modelAndView.addObject("options", options);
        modelAndView.addObject("types", typeService.findAll(pageNumber, pageSize, orderBy, orderDir));
        return modelAndView;
    }

    @GetMapping("/new")
    public ModelAndView newCategory() {
        ModelAndView modelAndView = new ModelAndView("administration/categories/new");
        modelAndView.addObject("category", new CreateCategoryDTO());
        return modelAndView;
    }

    @PostMapping("/new")
    public ModelAndView newCategory(@ModelAttribute CreateCategoryDTO categoryDto) {
        if (categoryDto.getCategoryType() == 1)
            regionService.save(new Region(categoryDto.getName()));

        if (categoryDto.getCategoryType() == 2)
            typeService.save(new Type(categoryDto.getName()));

        return new ModelAndView("administration/categories/new", "category", categoryDto);
    }

    @GetMapping("/region/delete/{id}")
    public ModelAndView deleteRegionAdmin(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("administration/categories/region/delete");
        modelAndView.addObject("category", regionService.findById(id).orElse(null));
        return modelAndView;
    }

    @GetMapping("/type/delete/{id}")
    public ModelAndView deleteTypeAdmin(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("administration/categories/type/delete");
        modelAndView.addObject("category", typeService.findById(id).orElse(null));
        return modelAndView;
    }

    @PostMapping("/region/delete/{id}")
    public String deleteRegionAdminPost(@PathVariable Long id) {
        regionService.deleteById(id);
        return "redirect:/administration/categories/region/list";
    }

    @PostMapping("/type/delete/{id}")
    public String deleteTypeAdminPost(@PathVariable Long id) {
        typeService.deleteById(id);
        return "redirect:/administration/categories/region/list";
    }



//    primero hacemos los pokemon
//    @GetMapping("/edit/{id}")
//    public ModelAndView editCategory(@PathVariable String id) {
//        ModelAndView modelAndView = new ModelAndView("administration/categories/edit/");
//        modelAndView.addObject("category", new CreateCategoryDTO());
//        return modelAndView;
//    }
//
//    @PostMapping("/edit/{id}")
//    public ModelAndView editCategory(@ModelAttribute CreateCategoryDTO categoryDto, @PathVariable String id) {
//        if (categoryDto.getCategoryType() == 1)
//            regionService.save(new Region(categoryDto.getName()));
//
//        if (categoryDto.getCategoryType() == 2)
//            typeService.save(new Type(categoryDto.getName()));
//
//        return new ModelAndView("administration/categories/new", "category", categoryDto);
//    }


}
