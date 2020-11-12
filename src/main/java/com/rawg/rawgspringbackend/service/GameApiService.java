package com.rawg.rawgspringbackend.service;

import com.rawg.rawgspringbackend.entity.RawGUser;
import com.rawg.rawgspringbackend.entity.WishlistItem;
import com.rawg.rawgspringbackend.model.generated.Games;
import com.rawg.rawgspringbackend.repository.UserRepository;
import com.rawg.rawgspringbackend.repository.WishlistRepository;
import lombok.extern.slf4j.Slf4j;
import com.rawg.rawgspringbackend.model.generated.game.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;



@Service
@Slf4j
public class GameApiService {

    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private UserRepository userRepository;


    public Games getAllGames(String queryString) {
        RestTemplate template = new RestTemplate();
        try {
            ResponseEntity<Games> gamesResponseEntity = template
                    .exchange(queryString,
                            HttpMethod.GET, null, Games.class);
            log.info("Request sent to: " + queryString);
            return gamesResponseEntity.getBody();
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public Game getGameById(String id) {
        RestTemplate template = new RestTemplate();
        var queryString = "https://api.rawg.io/api/games" + "/" + id;
        try {
            ResponseEntity<Game> gameResponseEntity = template
                    .exchange(queryString, HttpMethod.GET, null, Game.class);
            return gameResponseEntity.getBody();
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public List<WishlistItem> getWishlist() {
        return wishlistRepository.findAll();
    }

    public void addWishListItemToUser(WishlistItem game, RawGUser user) {
        Optional<WishlistItem> gameFromRepo = wishlistRepository.findByGameId(game.getGameId());
        if (gameFromRepo.isEmpty()) {
            WishlistItem item = WishlistItem
                    .builder()
                    .background_image(game.getBackground_image())
                    .name(game.getName())
                    .gameId(game.getGameId())
                    .rating(game.getRating())
                    .released(game.getReleased())
                    .usersWhoLiked(new HashSet<>())
                    .build();

            user.getUserLikedGames().add(item);
            item.getUsersWhoLiked().add(user);
            wishlistRepository.save(item);

        } else {
            user.getUserLikedGames().add(gameFromRepo.get());
            gameFromRepo.get().getUsersWhoLiked().add(user);
            wishlistRepository.save(gameFromRepo.get());
        }

    }

}
