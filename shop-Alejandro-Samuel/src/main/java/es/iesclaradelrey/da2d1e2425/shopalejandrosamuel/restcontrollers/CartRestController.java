package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.restcontrollers;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.PokemonDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.PokemonService;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.ProductInCartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/api/v1/pokemones")
public class CartRestController {

    PokemonService pokemonService;
    ProductInCartService productInCartService;

    CartRestController(PokemonService pokemonService, ProductInCartService productInCartService) {
        this.pokemonService = pokemonService;
        this.productInCartService = productInCartService;
    }

    @PostMapping
    public ResponseEntity<String> checkAvailable(@RequestBody PokemonDTO pokemonDTO){
            productInCartService.createOrUpdateProductInCart(pokemonDTO.getId(), pokemonDTO.getProductNumber());
            return ResponseEntity.created(null).body("Producto añadido correctamente.");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAll(@RequestBody PokemonDTO pokemonDTO){
        productInCartService.deleteAll();
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{pokemonId}")
    public ResponseEntity<String> deletePokemon(@PathVariable("pokemonId") Long pokemonId){
        productInCartService.delete(pokemonId);
        return ResponseEntity.ok(null);
    }


}
