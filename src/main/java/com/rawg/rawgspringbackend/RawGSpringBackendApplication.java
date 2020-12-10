package com.rawg.rawgspringbackend;

import com.rawg.rawgspringbackend.entity.RawGUser;
import com.rawg.rawgspringbackend.repository.UserRepository;
import com.rawg.rawgspringbackend.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
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
    public CommandLineRunner init(ApplicationContext ctx) {
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


            System.out.println("Let's inspect the beans provided by Spring Boot:");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }

}
