package com.rawg.rawgspringbackend.controller;

import com.rawg.rawgspringbackend.entity.RawGUser;
import com.rawg.rawgspringbackend.model.UserCredentials;
import com.rawg.rawgspringbackend.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
public class AuthController {
    @Autowired
    ApiService apiService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/api/register")
    @ResponseBody
    public RawGUser register(@RequestBody RawGUser user) {
        return apiService.registerUser(user);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/api/login")
    @ResponseBody
    public String login(@RequestBody UserCredentials user) {
        return "Logged in";
    }


}
