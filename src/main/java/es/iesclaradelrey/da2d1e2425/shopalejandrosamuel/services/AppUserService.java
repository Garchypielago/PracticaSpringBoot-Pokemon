package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.RegisterUserDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.AppUser;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.LoginUserDTO;

import java.util.List;
import java.util.Optional;

public interface AppUserService {


    AppUser register(RegisterUserDTO registerUserDTO);

    AppUser login(LoginUserDTO loginUserDTO);

    Optional<AppUser> findByEmail(String email);

    List<AppUser> findAll();

    void save(AppUser appUser);
}
