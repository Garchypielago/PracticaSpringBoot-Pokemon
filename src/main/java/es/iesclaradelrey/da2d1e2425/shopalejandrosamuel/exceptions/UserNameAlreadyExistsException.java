package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.exceptions;

public class UserNameAlreadyExistsException extends RuntimeException {
    public UserNameAlreadyExistsException(String email) {
        super(String.format("User with email %s already exists", email));
    }
}
