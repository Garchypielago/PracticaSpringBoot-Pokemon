package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.AppPokemonDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Pokemon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> , JpaSpecificationExecutor<Pokemon> {

    Collection<Pokemon> findByRegion_Id(Long region);
    Collection<Pokemon> findPokemonByType1_IdOrType2_Id(Long type1_id, Long type2_id);

    @Query(value = "select avg(mark) from pokemones p\n" +
            "inner join ratings r on  r.pokemon_id=p.id\n" +
            "where p.id = :id", nativeQuery = true)
    Double avgRatingsFromPokemon(@Param("id") Long pokemon_id);

    @Query(value = "select max(id) from pokemones", nativeQuery = true)
    Long findMaxId();

    @Query(value = "select count(id) from pokemones p where p.name = :name and p.id!=:id", nativeQuery = true)

    Long sameName(@Param("id") Long id, @Param("name") String name );

    void deleteByRegion_Id(Long regionId);

    void deleteByType1_IdOrType2_Id(Long type1Id, Long type2Id);


    Page<AppPokemonDTO> findAllByType1_IdOrType2_Id(Long type1_id, Long type2_id , Pageable pageable);

}
