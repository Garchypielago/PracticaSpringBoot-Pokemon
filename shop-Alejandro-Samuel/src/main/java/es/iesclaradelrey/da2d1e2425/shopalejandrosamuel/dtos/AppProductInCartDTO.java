package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.Pokemon;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.ProductInCart;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class AppProductInCartDTO {

        private Long id;

        private Long pokemonId;

        private String pokemonName;

        private String url;

        private Long productNumber;

        private Double unitPrice;

        private Double totalPrice;


        public AppProductInCartDTO(Long id, Pokemon pokemon, Long productNumber) {
            this.id = id;
            this.pokemonId = pokemon.getId();
            this.pokemonName = pokemon.getName();
            this.productNumber = productNumber;
            this.unitPrice = pokemon.getPrice();
            this.url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + pokemon.getId() + ".png";

            updateTotalPrice();
        }

        public void add(Long quantity){
            this.productNumber = this.productNumber + quantity;
            updateTotalPrice();
        }

        public void updateTotalPrice(){
            this.totalPrice = this.productNumber * this.unitPrice;
        }

    }


