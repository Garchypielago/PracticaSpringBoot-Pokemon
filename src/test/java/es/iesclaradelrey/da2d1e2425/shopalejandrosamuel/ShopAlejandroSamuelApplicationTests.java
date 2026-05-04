package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.config.WebSecurityConfig;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.controllers.HomeController;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.controllers.admin.AdminController;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Pokemon;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Region;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Type;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.filters.JwtAuthenticationFilter;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services.PokemonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {HomeController.class, AdminController.class})
@Import(WebSecurityConfig.class)
class ShopAlejandroSamuelApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PokemonService pokemonService;

    @MockBean
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @BeforeEach
    void setUp() {
        Pokemon pokemon = new Pokemon();
        pokemon.setId(1L);
        pokemon.setName("Bulbasaur");
        pokemon.setDescription("Starter");
        pokemon.setPrice(54.50);

        Type type = new Type();
        type.setId(12L);
        type.setName("GRASS");
        type.setBackground("/shopedex/fondoplanta.jpg");
        pokemon.setType1(type);

        Region region = new Region();
        region.setId(1L);
        region.setName("KANTO");
        pokemon.setRegion(region);

        when(pokemonService.findAll()).thenReturn(List.of(pokemon));
        when(pokemonService.findById(1L)).thenReturn(Optional.of(pokemon));
    }

    @Test
    void anonymousCanLoadHomePage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    void anonymousCanLoadLoginPage() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk());
    }

    @Test
    void anonymousIsRedirectedFromAdmin() throws Exception {
        mockMvc.perform(get("/admin"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern("**/login"));
    }

    @Test
    @WithMockUser(roles = "USER")
    void userRoleCannotAccessAdmin() throws Exception {
        mockMvc.perform(get("/admin"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void adminRoleCanAccessAdmin() throws Exception {
        mockMvc.perform(get("/admin"))
                .andExpect(status().isOk());
    }
}
