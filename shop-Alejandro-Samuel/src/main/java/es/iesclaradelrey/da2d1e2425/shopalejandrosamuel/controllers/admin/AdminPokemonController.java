package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.controllers.admin;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.CreatePokemonDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.PokemonService;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.RegionService;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.TypeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
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

//    @GetMapping({"/", ""})
//    public ModelAndView pokemonListAdmin() {
//        ModelAndView modelAndView = new ModelAndView("administration/pokemons/list");
//        modelAndView.addObject("pokemons", pokemonService.findAll());
//        return modelAndView;
//    }

    @GetMapping({"/list"})
    public ModelAndView pokemonListAdmin(@RequestParam(defaultValue = "1") Integer pageNumber,
                                         @RequestParam(defaultValue = "10")Integer pageSize,
                                         @RequestParam(defaultValue = "id") String orderBy,
                                         @RequestParam(defaultValue = "asc")String orderDir,
                                         Model model) {

        Map<String, String> options = new HashMap<String, String>();
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

        return modelAndView;
    }

    @GetMapping("/new")
    public ModelAndView newPokemonAdmin() {
        ModelAndView modelAndView = new ModelAndView("administration/pokemons/new");
        modelAndView.addObject("pokemon", new CreatePokemonDTO());
        modelAndView.addObject("regions", regionService.findAll());
        modelAndView.addObject("pokemons", pokemonService.findAll());
        modelAndView.addObject("types", typeService.findAll());

        return modelAndView;
    }

    @PostMapping("/new")
    public ModelAndView newPokemonAdmin(@Valid @ModelAttribute("pokemon") CreatePokemonDTO pokemonDTO, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("administration/pokemons/new");
        modelAndView.addObject("regions", regionService.findAll());
        modelAndView.addObject("pokemons", pokemonService.findAll());
        modelAndView.addObject("types", typeService.findAll());
//        modelAndView.addObject("pokemon", pokemonDTO);

        if (bindingResult.hasErrors()) {
            return modelAndView;
        }
        pokemonService.saveFromDTO(pokemonDTO);
        return modelAndView;
    }

}
