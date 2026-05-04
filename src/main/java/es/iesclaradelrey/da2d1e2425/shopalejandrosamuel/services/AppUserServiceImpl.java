package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.services;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.LoginUserDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos.RegisterUserDTO;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.AppUser;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.enums.AppUserRole;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.exceptions.UserNameAlreadyExistsException;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.AppUserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AppUserServiceImpl(AppUserRepository appUserRepository,
                              PasswordEncoder passwordEncoder,
                              AuthenticationManager authenticationManager) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public AppUser register(RegisterUserDTO registerUserDTO) {
        if (appUserRepository.existsByEmail(registerUserDTO.getEmail())) {
            throw new UserNameAlreadyExistsException(registerUserDTO.getEmail());
        }

        AppUser appUser = AppUser.builder()
                .email(registerUserDTO.getEmail())
                .password(passwordEncoder.encode(registerUserDTO.getPassword()))
                .firstName(registerUserDTO.getFirstName())
                .lastName(registerUserDTO.getLastName())
                .role(AppUserRole.USER)
                .build();

        return appUserRepository.save(appUser);
    }

    @Override
    public AppUser login(LoginUserDTO loginUserDTO) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginUserDTO.getEmail(), loginUserDTO.getPassword());

        authenticationManager.authenticate(authenticationToken);
        return appUserRepository.findByEmail(loginUserDTO.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Authenticated user not found"));
    }

    @Override
    public Optional<AppUser> findByEmail(String email) {
        return appUserRepository.findByEmail(email);
    }

    @Override
    public List<AppUser> findAll() {
        return appUserRepository.findAll();
    }

    @Override
    public void save(AppUser appUser) {
        appUserRepository.save(appUser);
    }
}
