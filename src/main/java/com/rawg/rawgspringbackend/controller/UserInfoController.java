package com.rawg.rawgspringbackend.controller;

import com.rawg.rawgspringbackend.entity.RawGUser;
import com.rawg.rawgspringbackend.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping
public class UserInfoController {
    @Autowired
    ApiService apiService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/api/user/{id}")
    public Optional<RawGUser> getGameById(@PathVariable Long id) {
        return apiService.getUserById(id);
    }
}
