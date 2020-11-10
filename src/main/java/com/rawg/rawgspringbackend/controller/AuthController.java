package com.rawg.rawgspringbackend.controller;

import com.rawg.rawgspringbackend.model.UserCredentialsLogin;
import com.rawg.rawgspringbackend.model.UserCredentialsRegister;
import com.rawg.rawgspringbackend.model.error.ErrorInfo;
import com.rawg.rawgspringbackend.service.UserApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping
public class AuthController {

    @Autowired
    UserApiService userApiService;

    @ExceptionHandler(value = {BadCredentialsException.class,
            IllegalStateException.class, ResponseStatusException.class,
            HttpClientErrorException.class})
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    protected ErrorInfo handleConflict(RuntimeException e) {
        return new ErrorInfo(e);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/auth/register")
    @ResponseBody
    public ResponseEntity register(@RequestBody UserCredentialsRegister userCredentialsRegister) {
        return userApiService.registerUser(userCredentialsRegister);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/auth/login")
    @ResponseBody
    public String login(@RequestBody UserCredentialsLogin user) {
        return "Logged in";
    }


}
