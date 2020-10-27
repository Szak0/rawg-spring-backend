package com.rawg.rawgspringbackend;

import com.rawg.rawgspringbackend.entity.RawGUser;
import com.rawg.rawgspringbackend.repository.RawGUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class RawGSpringBackendApplication {
    @Autowired
    RawGUserRepository rawGUserRepository;

    public static void main(String[] args) {
        SpringApplication.run(RawGSpringBackendApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init() {
        return args -> {
            RawGUser user = RawGUser
                    .builder()
                    .userName("Tomi")
                    .email("tomi1@meno.com")
                    .password("tej")
                    .build();
            if (rawGUserRepository.getRawGUserByEmailOrUserName(user.getEmail(), user.getUserName()).size() == 0) {
                rawGUserRepository.save(user);

            }
        };
    }
}
