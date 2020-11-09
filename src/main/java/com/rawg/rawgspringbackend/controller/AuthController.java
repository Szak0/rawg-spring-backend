package com.rawg.rawgspringbackend.controller;

import com.rawg.rawgspringbackend.model.UserCredentialsLogin;
import com.rawg.rawgspringbackend.model.UserCredentialsRegister;
import com.rawg.rawgspringbackend.service.UserApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AuthController {

    @Autowired
    UserApiService userApiService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/auth/register")
    @ResponseBody
    public String register(@RequestBody UserCredentialsRegister userCredentialsRegister) {
        return userApiService.registerUser(userCredentialsRegister);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/auth/login")
    @ResponseBody
    public String login(@RequestBody UserCredentialsLogin user) {
        return "Logged in";
    }


}
