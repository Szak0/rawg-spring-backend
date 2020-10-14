package com.rawg.rawgspringbackend.service;


import com.rawg.rawgspringbackend.RawGSpringBackendApplication;
import com.rawg.rawgspringbackend.model.generated.Games;
import com.rawg.rawgspringbackend.model.generated.exception.InvalidEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.rawg.rawgspringbackend.model.generated.exception.InvalidEndpointGame;
import com.rawg.rawgspringbackend.model.generated.game.Game;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@Service
public class RawGAPIService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RawGAPIService.class);

    @Value("${rawG.games.url}")
    private String gamesURL;

    public Games getAllGames(String pageNumber, String search, String ordering, String date, String page_size) {
        RestTemplate template = new RestTemplate();
        List<String> orderingParams = Arrays
                .asList("released", "added", "created", "rating",
                "-released", "-added", "-created", "-rating", "");
        if (!orderingParams.contains(ordering)) {
            return new InvalidEndpoint("Not a valid ordering parameter!");
        }
        try {
            var queryString = gamesURL
                    + "?page=" + pageNumber
                    + "&search=" + search + "&ordering=" + ordering
                    + "&date=" + date + "&page_size=" + page_size;
            ResponseEntity<Games> gamesResponseEntity = template
                    .exchange(queryString,
                            HttpMethod.GET, null, Games.class);
            LOGGER.info("Request sent to: " + queryString);
            return gamesResponseEntity.getBody();
        } catch (HttpClientErrorException e) {
            return new InvalidEndpoint("Not Found " + e.getStatusCode().value() + " Error");
        }
    }

    public Game getGameById(String id) {
            RestTemplate template = new RestTemplate();
            var queryString = gamesURL + "/" + id;
            try {
                    ResponseEntity<Game> gameResponseEntity = template
                            .exchange(queryString, HttpMethod.GET, null, Game.class);
                    return gameResponseEntity.getBody();
            } catch (HttpClientErrorException e) {
                    return new InvalidEndpointGame("Not Found " + e.getStatusCode().value() + " Error");
            }
    }
}
