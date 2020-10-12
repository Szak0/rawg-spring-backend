package com.rawg.rawgspringbackend.controller;

import com.rawg.rawgspringbackend.model.generated.Games;
import com.rawg.rawgspringbackend.service.RawGAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class GamesController {
    @Autowired
    private RawGAPIService apiService;

    @GetMapping("/api/games")
    @ResponseBody
    public Games getAllGames(@RequestParam String page) {
        return apiService.getAllGames(Objects.requireNonNullElse(page, "1"));
    }
}
