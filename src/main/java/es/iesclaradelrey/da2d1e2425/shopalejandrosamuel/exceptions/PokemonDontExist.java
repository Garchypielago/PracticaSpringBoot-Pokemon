package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class PokemonDontExist extends EntityNotFoundException {
    public PokemonDontExist(String message) {
        super(message);
    }
}
