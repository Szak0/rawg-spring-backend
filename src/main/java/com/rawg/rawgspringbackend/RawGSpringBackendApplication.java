package com.rawg.rawgspringbackend;

import com.rawg.rawgspringbackend.entity.RawGUser;
import com.rawg.rawgspringbackend.entity.WishlistItem;
import com.rawg.rawgspringbackend.repository.RawGUserRepository;
import com.rawg.rawgspringbackend.repository.WishlistItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class RawGSpringBackendApplication {
    @Autowired
    RawGUserRepository rawGUserRepository;

    @Autowired
    WishlistItemRepository wishlistItemRepository;

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
                    .password("tej123456")
                    .registrationDate(LocalDateTime.now())
                    .build();
            rawGUserRepository.save(user);


            WishlistItem wishlistItem = WishlistItem
                    .builder()
                    .gameId(1L)
                    .name("ASD")
                    .background_image("startlap.hu")
                    .released("2020")
                    .rating(5.2)
                    .build();
            wishlistItemRepository.save(wishlistItem);
        };
    }

}
