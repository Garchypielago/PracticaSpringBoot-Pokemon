package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.restcontrollers;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.controllers.CartController;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.PokemonDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Pokemon;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.ProductInCart;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.exceptions.PokemonDontExist;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.exceptions.PokemonNoQuantityAvalaible;
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

//    @GetMapping
//    public ResponseEntity<Collection<ProductInCart>> okGet() {
//        return ResponseEntity.ok(productInCartService.findAll());
//    }

    @PostMapping
    public ResponseEntity<String> checkAvailable(@RequestBody PokemonDTO pokemonDTO){
//        return ResponseEntity.ok("ok");
        long cartQuantity = productInCartService.getQuantityByPokemonId(pokemonDTO.getId()) + pokemonDTO.getProductNumber();

        try{
            pokemonService.existsById(pokemonDTO.getId());
            pokemonService.quantityAvalaible(pokemonDTO.getId(),cartQuantity);
            productInCartService.createOrUpdateProductInCart(pokemonDTO.getId(), pokemonDTO.getProductNumber());

            return ResponseEntity.created(null).body("Producto añadido correctamente.");
        } catch (PokemonDontExist e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (PokemonNoQuantityAvalaible e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }


}
