package com.rawg.rawgspringbackend.controller;

import com.rawg.rawgspringbackend.model.QueryString;
import com.rawg.rawgspringbackend.model.error.ErrorInfo;
import com.rawg.rawgspringbackend.model.generated.Games;
import com.rawg.rawgspringbackend.model.generated.game.Game;
import com.rawg.rawgspringbackend.service.GameApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;


import java.util.Objects;

@RestController
@RequestMapping
public class GamesController {

    @Autowired
    private GameApiService gameApiService;

    @ExceptionHandler(value = {IllegalArgumentException.class,
            IllegalStateException.class, ResponseStatusException.class,
            HttpClientErrorException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorInfo handleConflict(RuntimeException e) {
        return new ErrorInfo(e);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/api/games", produces = {"application/json"})
    public Games getAllGames(@RequestParam(required = false) String page, String search,
                             String ordering, String dates, String page_size, String tags) {

        // todo move this into QueryString.class
        // todo delete THIS ASAP
        QueryString queryString = new QueryString(
                Objects.requireNonNullElse(page, "1"),
                Objects.requireNonNullElse(search, ""),
                Objects.requireNonNullElse(ordering, ""),
                Objects.requireNonNullElse(dates, ""),
                Objects.requireNonNullElse(page_size, "10"),
                Objects.requireNonNullElse(tags, ""));

        return gameApiService
                .getAllGames(queryString.getQueryString());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/game/{id}")
    public Game getGameById(@PathVariable String id) {
        return gameApiService.getGameById(id);
    }
}
