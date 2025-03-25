package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.controllers.admin;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.CreateCategoryDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.CreateEditTypeDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.CreateEditRegionDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Region;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Type;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.RegionService;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.TypeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

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
    public ModelAndView regionList(@RequestParam(defaultValue = "1") Integer pageNumber,
                                   @RequestParam(defaultValue = "10")Integer pageSize,
                                   @RequestParam(defaultValue = "id") String orderBy,
                                   @RequestParam(defaultValue = "asc")String orderDir,
                                   Model model,
                                   HttpServletRequest request) {

        boolean editado=false;
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);

        Map<String, String> options = new LinkedHashMap<String, String>();
        options.put("Id", "id");
        options.put("Name", "name");

        ModelAndView modelAndView = new ModelAndView("administration/categories/region/list");
        modelAndView.addObject("orderBy", orderBy);
        modelAndView.addObject("orderDir", orderDir);
        modelAndView.addObject("options", options);
        modelAndView.addObject("regions", regionService.findAll(pageNumber, pageSize, orderBy, orderDir));
        if (inputFlashMap != null) {
            CreateEditRegionDTO editedCategory = (CreateEditRegionDTO) inputFlashMap.get("editedCategory");
            editado=true;
            modelAndView.addObject("editedCategory", editedCategory);
        }
        modelAndView.addObject("editado", editado);
        return modelAndView;
    }

    @GetMapping({"/type/list"})
    public ModelAndView typeList(@RequestParam(defaultValue = "1") Integer pageNumber,
                                 @RequestParam(defaultValue = "10")Integer pageSize,
                                 @RequestParam(defaultValue = "id") String orderBy,
                                 @RequestParam(defaultValue = "asc")String orderDir,
                                 Model model,
                                 HttpServletRequest request) {

        boolean editado=false;
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);


        Map<String, String> options = new LinkedHashMap<String, String>();
        options.put("Id", "id");
        options.put("Name", "name");

        ModelAndView modelAndView = new ModelAndView("administration/categories/type/list");
        modelAndView.addObject("orderBy", orderBy);
        modelAndView.addObject("orderDir", orderDir);
        modelAndView.addObject("options", options);
        modelAndView.addObject("types", typeService.findAll(pageNumber, pageSize, orderBy, orderDir));
        if (inputFlashMap != null) {
            CreateEditTypeDTO editedCategory = (CreateEditTypeDTO) inputFlashMap.get("editedCategory");
            editado=true;
            modelAndView.addObject("editedCategory", editedCategory);
        }
        modelAndView.addObject("editado", editado);
        return modelAndView;
    }

    @GetMapping("/new")
    public ModelAndView newCategory() {
        ModelAndView modelAndView = new ModelAndView("administration/categories/new");
        modelAndView.addObject("category", new CreateCategoryDTO());
        return modelAndView;
    }

    @PostMapping("/new")
    public String newCategory(@Valid @ModelAttribute("category") CreateCategoryDTO categoryDto,BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {

        if (bindingResult.hasErrors()) {

            return "administration/categories/new";
        }
        if (categoryDto.getCategoryType() == 1) {
            regionService.save(new Region(categoryDto.getName()));
            redirectAttributes.addFlashAttribute("message", "Region saved succesfully");
        }

        if (categoryDto.getCategoryType() == 2) {
            typeService.save(new Type(categoryDto.getName()));
            redirectAttributes.addFlashAttribute("message", "Type saved succesfully");
        }

        return "redirect:/admin/categories/new";
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
        return "redirect:/admin/categories/region/list";
    }

    @PostMapping("/type/delete/{id}")
    public String deleteTypeAdminPost(@PathVariable Long id) {
        typeService.deleteById(id);
        return "redirect:/admin/categories/type/list";
    }


    @GetMapping("/{category}/edit/{id}")
    public ModelAndView editCategory(@PathVariable Long id, @PathVariable String category) {
        ModelAndView modelAndView = new ModelAndView("administration/home");

        if (category.equals("type")){
            modelAndView = new ModelAndView("administration/categories/type/edit");
            modelAndView.addObject("categoryDTO", new CreateEditTypeDTO(typeService.findById(id).orElse(null)));
            System.out.println("pasa por aqui");
        }
        if (category.equals("region")){
            modelAndView = new ModelAndView("administration/categories/region/edit");
            modelAndView.addObject("categoryDTO", new CreateEditRegionDTO(regionService.findById(id).orElse(null)));
        }

        return modelAndView;
    }

    @PostMapping("/type/edit/{id}")
    public RedirectView editCategory(@ModelAttribute CreateEditTypeDTO categoryDto,  RedirectAttributes redirectAttributes) {
        typeService.editFromDTO(categoryDto);
        redirectAttributes.addFlashAttribute("editedCategory", categoryDto);
        return new RedirectView("/admin/categories/type/list", true);
    }
    @PostMapping("/region/edit/{id}")
    public RedirectView editCategory(@ModelAttribute CreateEditRegionDTO categoryDto,  RedirectAttributes redirectAttributes) {
        regionService.editFromDTO(categoryDto);
        redirectAttributes.addFlashAttribute("editedCategory", categoryDto);
        return new RedirectView("/admin/categories/region/list", true);
    }


}
