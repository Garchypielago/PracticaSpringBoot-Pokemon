package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.restcontrollers;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.AppPokemonDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.AppProductInCartDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.AppRegionDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.AppTypeDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.PokemonService;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.ProductInCartService;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.RegionService;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.TypeService;
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

    AppRestController(PokemonService pokemonService, ProductInCartService productInCartService, RegionService regionService, TypeService typeService) {
        this.pokemonService = pokemonService;
        this.productInCartService = productInCartService;
        this.regionService = regionService;
        this.typeService = typeService;
    }
    @GetMapping("/products/find")
    public ResponseEntity<Page<AppPokemonDTO>> findProducts(@RequestParam(required = false) String search,
                                               @RequestParam(defaultValue = "1") Long cat,
                                               @RequestParam(defaultValue = "1") Integer pageNumber,
                                               @RequestParam(defaultValue = "10")Integer pageSize,
                                               @RequestParam(defaultValue = "id") String orderBy,
                                               @RequestParam(defaultValue = "asc")String orderDir){

        Page<AppPokemonDTO> pokemons = pokemonService.findByTypeId(cat, pageNumber, pageSize, orderBy, orderDir);
      return ResponseEntity.ok(pokemons);
    }

    @GetMapping("/cart")
    public ResponseEntity<List<AppProductInCartDTO>> findProductsInCart(){
        List<AppProductInCartDTO> products = productInCartService.findAllDTO();
        return ResponseEntity.ok(products);
    }

    @PostMapping("/cart/{productId}")
    public ResponseEntity<List<AppProductInCartDTO>> addOneProduct(@PathVariable("productId") Long pokemonId){
        productInCartService.createOrUpdateProductInCart(pokemonId, 1L);
        List<AppProductInCartDTO> products = productInCartService.findAllDTO();
        return ResponseEntity.ok(products);
    }

    @PostMapping("/cart/{productId}/{count}")
    public ResponseEntity<List<AppProductInCartDTO>> addNProduct(@PathVariable("productId") Long pokemonId,
                                                                              @PathVariable("count") Long count){
        productInCartService.createOrUpdateProductInCart(pokemonId, count);
        List<AppProductInCartDTO> products = productInCartService.findAllDTO();
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/cart/{productId}")
    public ResponseEntity<List<AppProductInCartDTO>> deleteOneProduct(@PathVariable("productId") Long pokemonId){
        productInCartService.delete(pokemonId);
        List<AppProductInCartDTO> products = productInCartService.findAllDTO();
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/cart")
    public ResponseEntity<List<AppProductInCartDTO>> deleteCart(){
        productInCartService.deleteAll();
        List<AppProductInCartDTO> products = productInCartService.findAllDTO();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/categories")
    public ResponseEntity<Map<String, List<?>>> getCategories(){
        Map<String, List<?>> categories = new HashMap<>();
        categories.put("regions", regionService.findAllDTO());
        categories.put("types", typeService.findAllDTO());

        return ResponseEntity.ok(categories);
    }

    @GetMapping("/categories/regions")
    public ResponseEntity<List<AppRegionDTO>> getCategoriesRegions(){
        List<AppRegionDTO> regions= regionService.findAllDTO();
        return ResponseEntity.ok(regions);
    }
    @GetMapping("/categories/types")
    public ResponseEntity<List<AppTypeDTO>> getCategoriesTypes(){
        List<AppTypeDTO> types= typeService.findAllDTO();
        return ResponseEntity.ok(types);
    }

}
