package com.rawg.rawgspringbackend.controller;
import com.rawg.rawgspringbackend.model.generated.Games;
import com.rawg.rawgspringbackend.service.RawGAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
public class GamesController {

    @Autowired
    private RawGAPIService apiService;

    @GetMapping("/api/games")
    @ResponseBody
    public Games getAllGames(@RequestParam(required = false) String page, String search, String ordering) {
        if (search == null) {
            search = "";
        }

        return apiService.getAllGames(Objects.requireNonNullElse(page, "1"), search, ordering);
    }
}
