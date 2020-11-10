package com.rawg.rawgspringbackend.controller;

import com.rawg.rawgspringbackend.model.UserCredentialsLogin;
import com.rawg.rawgspringbackend.model.UserCredentialsRegister;
import com.rawg.rawgspringbackend.model.error.ErrorInfo;
import com.rawg.rawgspringbackend.security.JwtTokenServices;
import com.rawg.rawgspringbackend.service.UserApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class AuthController {

    @Autowired
    UserApiService userApiService;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenServices jwtTokenServices;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenServices jwtTokenServices) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenServices = jwtTokenServices;
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
    public ResponseEntity login(@RequestBody UserCredentialsLogin loginData) {
        try {
            String userEmail = loginData.getEmail();
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userEmail, loginData.getPassword()));
            List<String> roles = authentication.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            String token = jwtTokenServices.createToken(userEmail, roles);

            Map<Object, Object> model = new HashMap<>();
            model.put("userEmail", userEmail);
            model.put("roles", roles);
            model.put("token", token);
            return ResponseEntity.ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid e-mail/password supplied");
        }
    }

    @ExceptionHandler(value = {BadCredentialsException.class,
            IllegalStateException.class, ResponseStatusException.class,
            HttpClientErrorException.class})
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    protected ErrorInfo handleConflict(RuntimeException e) {
        return new ErrorInfo(e);
    }

}
