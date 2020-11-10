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
import java.util.Set;


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

    public void addWishListItemToUser(WishlistItem data, RawGUser user) {
        Optional<WishlistItem> gameFromRepo = wishlistRepository.findByGameId(data.getGameId());
        if (gameFromRepo.isEmpty()) {
            WishlistItem item = WishlistItem
                    .builder()
                    .background_image(data.getBackground_image())
                    .name(data.getName())
                    .gameId(data.getGameId())
                    .rating(data.getRating())
                    .released(data.getReleased())
                    .build();
            wishlistRepository.save(item);
            Set<WishlistItem> likedGames = user.getLikedGames();
            likedGames.add(data);
            user.setLikedGames(likedGames);
            Set<WishlistItem> likedGameSet = user.getLikedGames();
            String userEmail = user.getEmail();
            userRepository.updateUser(likedGameSet, userEmail);
        } else {

        }

    }

}
