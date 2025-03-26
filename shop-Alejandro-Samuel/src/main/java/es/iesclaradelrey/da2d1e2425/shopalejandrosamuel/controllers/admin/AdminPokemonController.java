package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.controllers.admin;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.CreateEditPokemonDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.CreateNewPokemonDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.exceptions.PokemonDuplicated;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.PokemonService;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.RegionService;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.TypeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/pokemons")
public class AdminPokemonController {
    private final PokemonService pokemonService;
    private final RegionService regionService;
    private final TypeService typeService;

    public AdminPokemonController(PokemonService pokemonService, RegionService regionService, TypeService typeService) {
        this.pokemonService = pokemonService;
        this.regionService = regionService;
        this.typeService = typeService;
    }

    @GetMapping({"/list"})
    public ModelAndView pokemonListAdmin(@RequestParam(defaultValue = "1") Integer pageNumber,
                                         @RequestParam(defaultValue = "10")Integer pageSize,
                                         @RequestParam(defaultValue = "id") String orderBy,
                                         @RequestParam(defaultValue = "asc")String orderDir,
                                         Model model,
                                         HttpServletRequest request) {


        boolean editado=false;
        boolean creado=false;
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);

        Map<String, String> options = new LinkedHashMap<String, String>();
        options.put("Id", "id");
        options.put("Name", "name");
        options.put("Region Id", "region.id");
        options.put("Region Name", "region.name");
        options.put("Type1 Id", "type1.id");
        options.put("Type1 Name", "type1.name");
        options.put("Type2 Id", "type2.id");
        options.put("Type2 Name", "type2.name");
        options.put("Price", "price");
        options.put("Stock", "stock");
        ModelAndView modelAndView = new ModelAndView("administration/pokemons/list");
        modelAndView.addObject("orderBy", orderBy);
        modelAndView.addObject("orderDir", orderDir);
        modelAndView.addObject("options", options);
        modelAndView.addObject("pokemons", pokemonService.findAll(pageNumber, pageSize, orderBy, orderDir));
        if (inputFlashMap != null) {
            if(inputFlashMap.containsKey("editedPokemon")) {
                CreateEditPokemonDTO editedPokemon = (CreateEditPokemonDTO) inputFlashMap.get("editedPokemon");
                editado = true;
                modelAndView.addObject("editedPokemon", editedPokemon);
            }
            if(inputFlashMap.containsKey("newPokemon")) {
                CreateNewPokemonDTO newPokemon = (CreateNewPokemonDTO) inputFlashMap.get("newPokemon");
                creado = true;
                modelAndView.addObject("newPokemon", newPokemon);
            }
        }
        modelAndView.addObject("edited", editado);
        modelAndView.addObject("created", creado);
        return modelAndView;
    }

    @GetMapping("/new")
    public ModelAndView newPokemonAdmin() {
        ModelAndView modelAndView = new ModelAndView("administration/pokemons/new");
        modelAndView.addObject("pokemon", new CreateNewPokemonDTO());
        modelAndView.addObject("regions", regionService.findAll());
        modelAndView.addObject("pokemons", pokemonService.findAll());
        modelAndView.addObject("types", typeService.findAll());

        return modelAndView;
    }

    @PostMapping("/new")
    public String newPokemonAdmin(@Valid @ModelAttribute("pokemon") CreateNewPokemonDTO pokemonDTO, BindingResult bindingResult, Model model,RedirectAttributes redirectAttributes) {
//        ModelAndView modelAndView = new ModelAndView("administration/pokemons/new");
        model.addAttribute("regions", regionService.findAll());
        model.addAttribute("pokemons", pokemonService.findAll());
        model.addAttribute("types", typeService.findAll());
        try {
            if (bindingResult.hasErrors()) {
                return "administration/pokemons/new";
            }
            pokemonService.saveFromDTO(pokemonDTO);
            redirectAttributes.addFlashAttribute("message", "New Pokemon added successfully");
        }
        catch (PokemonDuplicated pd){
            bindingResult.rejectValue("name", "admin.pokemon.name.duplicated", pd.getMessage());
            return "administration/pokemons/new";
        }

        return "redirect:/admin/pokemons/new";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deletePokemonAdmin(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("administration/pokemons/delete");
        modelAndView.addObject("pokemon", pokemonService.findById(id).orElse(null));
        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public String DeletePokemonAdmin(@PathVariable Long id) {
        pokemonService.deleteById(id);
        return "redirect:/admin/pokemons/list";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editPokemonAdmin(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("administration/pokemons/edit");
        modelAndView.addObject("pokemonDTO", new CreateEditPokemonDTO(pokemonService.findById(id).orElse(null)));
        modelAndView.addObject("regions", regionService.findAll());
        modelAndView.addObject("types", typeService.findAll());
        modelAndView.addObject("id", id);

        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public String editPokemonAdmin(@PathVariable Long id,
                                   @Valid @ModelAttribute("pokemonDTO") CreateEditPokemonDTO pokemonDTO,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes,
                                   Model model) {
        model.addAttribute("regions", regionService.findAll());
        model.addAttribute("types", typeService.findAll());
        model.addAttribute("id", id);

        try {
            if (!bindingResult.hasErrors()) {
                pokemonService.editFromDTO(pokemonDTO);
                redirectAttributes.addFlashAttribute("editedPokemon", pokemonDTO);
                return "redirect:/admin/pokemons/list";
            }

        }
        catch (PokemonDuplicated pd){
            bindingResult.rejectValue("name", "admin.pokemon.name.duplicated", pd.getMessage());
        }


        return "administration/pokemons/edit";
    }


}
