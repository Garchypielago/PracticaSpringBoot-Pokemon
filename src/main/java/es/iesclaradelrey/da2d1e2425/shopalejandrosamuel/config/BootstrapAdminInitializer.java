package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.config;

import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities.AppUser;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.enums.AppUserRole;
import es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.repositories.AppUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BootstrapAdminInitializer implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(BootstrapAdminInitializer.class);

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final ShopedexBootstrapAdminProperties properties;

    public BootstrapAdminInitializer(AppUserRepository appUserRepository,
                                     PasswordEncoder passwordEncoder,
                                     ShopedexBootstrapAdminProperties properties) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.properties = properties;
    }

    @Override
    public void run(ApplicationArguments args) {
        if (!properties.isConfigured()) {
            log.warn("Bootstrap admin incompleto. Se omite la creacion del usuario administrador.");
            return;
        }

        appUserRepository.findByEmail(properties.getEmail())
                .ifPresentOrElse(existingUser -> {
                    existingUser.setFirstName(properties.getFirstName());
                    existingUser.setLastName(properties.getLastName());
                    existingUser.setPassword(passwordEncoder.encode(properties.getPassword()));
                    existingUser.setRole(AppUserRole.ADMIN);
                    appUserRepository.save(existingUser);
                    log.info("Usuario bootstrap admin sincronizado para {}.", properties.getEmail());
                }, this::createAdminUser);
    }

    private void createAdminUser() {
        AppUser adminUser = AppUser.builder()
                .email(properties.getEmail())
                .password(passwordEncoder.encode(properties.getPassword()))
                .firstName(properties.getFirstName())
                .lastName(properties.getLastName())
                .role(AppUserRole.ADMIN)
                .build();

        appUserRepository.save(adminUser);
        log.info("Usuario bootstrap admin creado para {}.", properties.getEmail());
    }
}
