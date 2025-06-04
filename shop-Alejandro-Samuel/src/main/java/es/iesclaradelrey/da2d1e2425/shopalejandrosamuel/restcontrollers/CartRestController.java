package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.restcontrollers;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.PokemonToCartDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.PokemonService;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.ProductInCartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cart/api")
public class CartRestController {

    PokemonService pokemonService;
    ProductInCartService productInCartService;

    CartRestController(PokemonService pokemonService, ProductInCartService productInCartService) {
        this.pokemonService = pokemonService;
        this.productInCartService = productInCartService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> checkAvailable(@RequestBody PokemonToCartDTO pokemonDTO){
        System.out.println("Antes del pr");
            productInCartService.createOrUpdateProductInCart(pokemonDTO.getId(), pokemonDTO.getProductNumber());
        System.out.println("Despues del pr");
            return ResponseEntity.created(null).body("Producto añadido correctamente.");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAll(@RequestBody PokemonToCartDTO pokemonDTO){
        productInCartService.deleteAll();
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/delete/{pokemonId}")
    public ResponseEntity<String> deletePokemon(@PathVariable("pokemonId") Long pokemonId){
        productInCartService.delete(pokemonId);
        return ResponseEntity.ok(null);
    }


}
