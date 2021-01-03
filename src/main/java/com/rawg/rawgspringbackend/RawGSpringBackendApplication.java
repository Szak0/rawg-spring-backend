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
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
@EnableSwagger2
public class RawGSpringBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(RawGSpringBackendApplication.class, args);
    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    WishlistRepository wishlistRepository;

    private final PasswordEncoder passwordEncoder;

    public RawGSpringBackendApplication() {
        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init() {
        return args -> {
            RawGUser user = RawGUser
                    .builder()
                    .userName("Admin")
                    .email("admin@rawg.com")
                    .password(passwordEncoder.encode("tej123456"))
                    .registrationDate(LocalDateTime.now())
                    .roles(Arrays.asList("ROLE_USER", "ROLE_ADMIN"))
                    .build();
            RawGUser user1 = RawGUser
                    .builder()
                    .userName("Gabor")
                    .email("gabor@rawg.com")
                    .password(passwordEncoder.encode("tej123456"))
                    .registrationDate(LocalDateTime.now())
                    .roles(Arrays.asList("ROLE_USER"))
                    .build();
            userRepository.save(user);
            userRepository.save(user1);
        };
    }

}
