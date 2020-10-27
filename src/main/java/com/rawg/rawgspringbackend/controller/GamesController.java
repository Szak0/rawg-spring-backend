package com.rawg.rawgspringbackend.controller;

import com.rawg.rawgspringbackend.entity.RawGUser;
import com.rawg.rawgspringbackend.model.QueryString;
import com.rawg.rawgspringbackend.model.error.ErrorInfo;
import com.rawg.rawgspringbackend.model.generated.Games;
import com.rawg.rawgspringbackend.model.generated.game.Game;
import com.rawg.rawgspringbackend.service.RawGAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;


import java.util.Objects;

@RestController
@RequestMapping
public class GamesController {

    @Autowired
    private RawGAPIService apiService;

    @ExceptionHandler(value = {IllegalArgumentException.class,
            IllegalStateException.class, ResponseStatusException.class,
            HttpClientErrorException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorInfo handleConflict(RuntimeException e) {
        return new ErrorInfo(e);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(value = "/api/games", produces = {"application/json"})
    public Games getAllGames(@RequestParam(required = false) String page, String search,
                             String ordering, String dates, String page_size, String tags) {

        // todo move this into QueryString.class
        QueryString queryString = new QueryString(
                Objects.requireNonNullElse(page, "1"),
                Objects.requireNonNullElse(search, ""),
                Objects.requireNonNullElse(ordering, ""),
                Objects.requireNonNullElse(dates, ""),
                Objects.requireNonNullElse(page_size, "10"),
                Objects.requireNonNullElse(tags, ""));

        return apiService
                .getAllGames(queryString.getQueryString());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/api/game/{id}")
    public Game getGameById(@PathVariable String id) {
        return apiService.getGameById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/register")
    @ResponseBody
    public RawGUser registerNewUser(@RequestBody RawGUser user) {
        return apiService.registerUser(user);
    }


}
