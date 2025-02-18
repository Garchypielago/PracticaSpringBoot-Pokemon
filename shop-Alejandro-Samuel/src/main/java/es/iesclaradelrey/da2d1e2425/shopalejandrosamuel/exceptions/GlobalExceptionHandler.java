package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PokemonDontExist.class)
    ResponseEntity<String> handleEntityNotFoundException(PokemonDontExist e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(PokemonNoQuantityAvalaible.class)
    ResponseEntity<String> handleTaskAssignmentAlreadyCompletedException(PokemonNoQuantityAvalaible e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

}
