package com.rawg.rawgspringbackend.service;

import com.rawg.rawgspringbackend.entity.RawGUser;
import com.rawg.rawgspringbackend.model.generated.Games;
import com.rawg.rawgspringbackend.repository.RawGUserRepository;
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

import java.util.List;

@Service
@Slf4j
public class RawGAPIService {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(RawGAPIService.class);

    @Autowired
    private RawGUserRepository userRepository;

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

    public RawGUser registerUser(RawGUser user) {
        if (userRepository.getRawGUserByEmailOrUserName(user.getEmail(),user.getUserName()).size() == 0){
            userRepository.save(user);
            return user;
        } else {
            return user;
        }

    }

    public List<RawGUser> getUserInformations(RawGUser user) {
        List<RawGUser> rawGUserByEmailAndPassword = userRepository.getRawGUserByEmailAndPassword(user.getEmail(), user.getPassword());
        System.out.println(rawGUserByEmailAndPassword);
        return rawGUserByEmailAndPassword;

    }
}
