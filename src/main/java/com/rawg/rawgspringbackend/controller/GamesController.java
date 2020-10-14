package com.rawg.rawgspringbackend.controller;
import com.rawg.rawgspringbackend.model.generated.Games;
import com.rawg.rawgspringbackend.model.generated.game.Game;
import com.rawg.rawgspringbackend.service.RawGAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Objects;

@RestController
public class GamesController {

    @Autowired
    private RawGAPIService apiService;


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/api/games")
    @ResponseBody
    public Games getAllGames(@RequestParam(required = false) String page, String search, String ordering, String date, String page_size) {
        return apiService
                .getAllGames(
                        Objects.requireNonNullElse(page, "1"),
                        Objects.requireNonNullElse(search, ""),
                        Objects.requireNonNullElse(ordering, ""),
                        Objects.requireNonNullElse(date, ""),
                        Objects.requireNonNullElse(page_size, "10")
                );
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/api/game/{id}")
    @ResponseBody
    public Game getGameById(@PathVariable String id) {
            return apiService.getGameById(id);
    }

}
