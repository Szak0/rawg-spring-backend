package com.rawg.rawgspringbackend.controller;
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
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;


import java.util.Objects;

@RestController
public class GamesController {

    @Autowired
    private RawGAPIService apiService;

    @ExceptionHandler(value
            = { IllegalArgumentException.class, IllegalStateException.class, ResponseStatusException.class, HttpClientErrorException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ErrorInfo handleConflict(
            RuntimeException ex) {
            return new ErrorInfo(ex);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/api/games")
    public Games getAllGames(@RequestParam(required = false) String page, String search, String ordering, String dates, String page_size) {
        return apiService
                .getAllGames(
                        Objects.requireNonNullElse(page, "1"),
                        Objects.requireNonNullElse(search, ""),
                        Objects.requireNonNullElse(ordering, ""),
                        Objects.requireNonNullElse(dates, ""),
                        Objects.requireNonNullElse(page_size, "10")
                );
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/api/game/{id}")
    public Game getGameById(@PathVariable String id) {
            return apiService.getGameById(id);
    }
}
