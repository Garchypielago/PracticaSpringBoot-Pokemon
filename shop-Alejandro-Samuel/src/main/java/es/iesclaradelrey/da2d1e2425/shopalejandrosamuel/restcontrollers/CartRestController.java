package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.restcontrollers;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.PokemonDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.PokemonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pokemon")
public class CartRestController {

    PokemonService pokemonService;

    CartRestController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    public String checkAvailable(PokemonDTO pokemonDTO){
        boolean exists = false;
        pokemonService.findAll().forEach(pokemon ->{
            if(pokemon.getId().equals(pokemonDTO.getId())){

            }
        })
        return "200";
    }

}
