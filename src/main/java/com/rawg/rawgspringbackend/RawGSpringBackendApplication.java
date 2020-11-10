package com.rawg.rawgspringbackend;

import com.rawg.rawgspringbackend.entity.RawGUser;
import com.rawg.rawgspringbackend.repository.UserRepository;
import com.rawg.rawgspringbackend.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class RawGSpringBackendApplication {
    @Autowired
    UserRepository userRepository;

    @Autowired
    WishlistRepository wishlistRepository;

    private final PasswordEncoder passwordEncoder;
    public RawGSpringBackendApplication() {
        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
    public static void main(String[] args) {
        SpringApplication.run(RawGSpringBackendApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init() {
        return args -> {
            RawGUser user = RawGUser
                    .builder()
                    .userName("Admin")
                    .email("tomi1@meno.com")
                    .password(passwordEncoder.encode("tej123456"))
                    .registrationDate(LocalDateTime.now())
                    .roles(Arrays.asList("ROLE_USER", "ROLE_ADMIN"))
                    .build();
            userRepository.save(user);
        };
    }

}
