package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.restcontrollers;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.AppPokemonDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.AppProductInCartDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.AppRegionDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.AppTypeDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.*;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping({"/api/app/v1"})
public class AppRestController {
    private final RegionService regionService;
    private final ProductInCartService productInCartService;
    private final PokemonService pokemonService;
    private final TypeService typeService;
    private final AuthService authService;

    AppRestController(PokemonService pokemonService, ProductInCartService productInCartService, RegionService regionService, TypeService typeService, AuthService authService) {
        this.pokemonService = pokemonService;
        this.productInCartService = productInCartService;
        this.regionService = regionService;
        this.typeService = typeService;
        this.authService = authService;
    }

    @GetMapping("/products/find")
    public ResponseEntity<Page<AppPokemonDTO>> findProducts(@RequestParam(required = false) String search,
                                                            @RequestParam(required = false) Long type,
                                                            @RequestParam(required = false) Long region,
                                                            @RequestParam(defaultValue = "1") Integer pageNumber,
                                                            @RequestParam(defaultValue = "10") Integer pageSize,
                                                            @RequestParam(defaultValue = "id") String orderBy,
                                                            @RequestParam(defaultValue = "asc") String orderDir) {



        if (type == null && region == null) {
            Page<AppPokemonDTO> pokemons = pokemonService.findAll(search, pageNumber, pageSize, orderBy, orderDir);
            return ResponseEntity.ok(pokemons);
        }

        if(type == null){
            Page<AppPokemonDTO> pokemons = pokemonService.findByRegionId(region, pageNumber, pageSize, orderBy, orderDir);
            return ResponseEntity.ok(pokemons);
        }

        if(region == null){
            Page<AppPokemonDTO> pokemons = pokemonService.findByTypeId(type, pageNumber, pageSize, orderBy, orderDir);
            return ResponseEntity.ok(pokemons);
        }

        Page<AppPokemonDTO> pokemons = pokemonService.findByTypeIdAndRegionId(type, region, pageNumber, pageSize, orderBy, orderDir);

        return ResponseEntity.ok(pokemons);
    }

    private ResponseEntity<Map<String, Object>> getMapResponseEntity() {
        Map<String, Object> cart = new HashMap<>();
        List<AppProductInCartDTO> products = productInCartService.findByUserIdApp(authService.getCurrentAppUserId());
        cart.put("products", products);
        int totalItems = products.size();
        cart.put("totalItems", totalItems);
        double totalPrice = productInCartService.getTotalPrice(authService.getCurrentAppUserId());
        cart.put("totalPrice", totalPrice);
        return ResponseEntity.ok(cart);
    }

    @GetMapping("/cart")
    public ResponseEntity<Map<String, Object>> findProductsInCart() {
        System.out.println("cart");
        return getMapResponseEntity();
    }

    @PostMapping("/cart/{pokemonId}")
    public ResponseEntity<Map<String, Object>> addOneProduct(@PathVariable("pokemonId") Long pokemonId) {
        productInCartService.createOrUpdateProductInCart(pokemonId, 1L);
        return getMapResponseEntity();
    }

    @PostMapping("/cart/{pokemonId}/{count}")
    public ResponseEntity<Map<String, Object>> addNProduct(@PathVariable("pokemonId") Long pokemonId,
                                                           @PathVariable("count") Long count) {
        productInCartService.createOrUpdateProductInCart(pokemonId, count);
        return getMapResponseEntity();
    }

    @DeleteMapping("/cart/{pokemonId}")
    public ResponseEntity<Map<String, Object>> deleteProduct(@PathVariable("pokemonId") Long pokemonId) {
        productInCartService.delete(pokemonId);
        return getMapResponseEntity();
    }

    @DeleteMapping("/cart")
    public ResponseEntity<Map<String, Object>> deleteCart() {
        productInCartService.deleteAll();
        return getMapResponseEntity();
    }

    @GetMapping("/categories")
    public ResponseEntity<Map<String, List<?>>> getCategories() {
        Map<String, List<?>> categories = new HashMap<>();
        categories.put("regions", regionService.findAllDTO());
        categories.put("types", typeService.findAllDTO());

        return ResponseEntity.ok(categories);
    }

    @GetMapping("/categories/regions")
    public ResponseEntity<List<AppRegionDTO>> getCategoriesRegions() {
        List<AppRegionDTO> regions = regionService.findAllDTO();
        return ResponseEntity.ok(regions);
    }

    @GetMapping("/categories/types")
    public ResponseEntity<List<AppTypeDTO>> getCategoriesTypes() {
        List<AppTypeDTO> types = typeService.findAllDTO();
        return ResponseEntity.ok(types);
    }

}