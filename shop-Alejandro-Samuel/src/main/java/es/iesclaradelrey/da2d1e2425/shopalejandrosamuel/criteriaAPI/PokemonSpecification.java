package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.criteriaAPI;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Pokemon;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;


public class PokemonSpecification implements Specification<Pokemon> {


    private final String search;
//    private final Long brandId;
//    private final Long categoryId;

    public PokemonSpecification(String search
//            , Long brandId, Long categoryId
    ) {
        this.search = search;
//        this.brandId = brandId;
//        this.categoryId = categoryId;
    }

    @Override
    public Predicate toPredicate(Root<Pokemon> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate finalPredicate = criteriaBuilder.conjunction();

        if (search != null && !search.isBlank()) {
            Predicate nameOrDescritionPredicate = criteriaBuilder.or(
                    criteriaBuilder.like(root.get("name"), String.format("%%%s%%", search)),
                    criteriaBuilder.like(root.get("description"), String.format("%%%s%%", search)));

            finalPredicate = criteriaBuilder.and(finalPredicate, nameOrDescritionPredicate);
        }

//        if (brandId != null) {
//            Join<Pokemon, Brand> productBrandJoin = root.join("brand", JoinType.INNER);
//
//            Predicate brandPredicate = criteriaBuilder.equal(productBrandJoin.get("id"), brandId);
//
//            finalPredicate = criteriaBuilder.and(finalPredicate, brandPredicate);
//        }
//
//        if (categoryId != null) {
//            Join<Pokemon, Category> productCategoryJoin = root.join("categories", JoinType.INNER);
//
//            Predicate categoryPredicate = criteriaBuilder.equal(productCategoryJoin.get("id"), categoryId);
//
//            finalPredicate = criteriaBuilder.and(finalPredicate, categoryPredicate);
//        }

        return finalPredicate;
    }

}
