package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.generic;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

}
