package com.rawg.rawgspringbackend.service;


import com.rawg.rawgspringbackend.model.generated.Games;
import com.rawg.rawgspringbackend.model.generated.exception.InvalidEndpoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class RawGAPIService {

    @Value("${rawG.games.url}")
    private String gamesURL;

    public Games getAllGames(String pageNumber, String search) {
        RestTemplate template = new RestTemplate();
        try {
            ResponseEntity<Games> gamesResponseEntity = template
                    .exchange(gamesURL + "?page=" + pageNumber + "&search=" + search,
                            HttpMethod.GET, null, Games.class);
            return gamesResponseEntity.getBody();
        } catch (HttpClientErrorException e) {
            return new InvalidEndpoint("Not a valid endpoint");
        }
    }
}
