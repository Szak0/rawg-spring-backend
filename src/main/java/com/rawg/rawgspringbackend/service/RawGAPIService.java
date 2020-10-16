package com.rawg.rawgspringbackend.service;

import com.rawg.rawgspringbackend.model.generated.Games;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class RawGAPIService {

    @Value("${rawG.games.url}")
    private String gamesURL;

    public Games getAllGames(String pageNumber, String search, String ordering, String dates, String page_size) {
        // TODO inject template & checks if template/logger was returned
        RestTemplate template = new RestTemplate();
        List<String> orderingParams = Arrays
                .asList("released", "added", "created", "rating",
                        "-released", "-added", "-created", "-rating", "");
        if (!orderingParams.contains(ordering)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        var queryString = gamesURL
                + "?page=" + pageNumber
                + "&search=" + search + "&ordering=" + ordering
                + "&dates=" + dates + "&page_size=" + page_size;
        try {
            ResponseEntity<Games> gamesResponseEntity = template
                    .exchange(queryString,
                            HttpMethod.GET, null, Games.class);
            log.info("Request sent to: " + queryString);
            return gamesResponseEntity.getBody();
        } catch (HttpClientErrorException e) {
             throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Game getGameById(String id) {
        // TODO inject template & checks if template/logger was returned
        RestTemplate template = new RestTemplate();
        var queryString = gamesURL + "/" + id;
        ResponseEntity<Game> gameResponseEntity = template
                .exchange(queryString, HttpMethod.GET, null, Game.class);
        return gameResponseEntity.getBody();
    }
}
