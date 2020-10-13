package com.rawg.rawgspringbackend.service;


import com.rawg.rawgspringbackend.model.generated.Games;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RawGAPIService {

    @Value("${rawG.games.url}")
    private String gamesURL;

    public Games getAllGames(String pageNumber, String search) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<Games> gamesResponseEntity = template.exchange("https://api.rawg.io/api/games?page=" + pageNumber,
                HttpMethod.GET, null, Games.class);
        return gamesResponseEntity.getBody();
    }
}
