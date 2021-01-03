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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping("/auth/login")
    @ResponseBody
    public ResponseEntity login(@RequestBody UserCredentialsLogin loginData, HttpServletResponse response) {
        try {
            String userEmail = loginData.getEmail();
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userEmail, loginData.getPassword()));
            List<String> roles = authentication.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());
            String userName = authentication.getName();
            String token = jwtTokenServices.createToken(userEmail, roles);
            getHttpOnlyCookie(response, token);
            Map<Object, Object> model = new HashMap<>();
            model.put("userEmail", userEmail);
            model.put("roles", roles);
            model.put("userName", userName);
            return ResponseEntity.ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid e-mail/password supplied");
        }
    }

    private void getHttpOnlyCookie(HttpServletResponse response, String token) {
        Cookie tokenCookie = new Cookie("token", token);
        int expiry = 7 * 24 * 60 * 60;
        tokenCookie.setMaxAge(expiry);
        tokenCookie.setSecure(false);
        tokenCookie.setHttpOnly(true);
        tokenCookie.setPath("/");
        response.addCookie(tokenCookie);
    }


    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @GetMapping("/auth/logout")
    @ResponseBody
    public ResponseEntity logOut(HttpServletResponse response, HttpServletRequest request) {
        try {
            removeTokenFromResponse(response);
            Map<Object, Object> model = new HashMap<>();
            model.put("Logout", "Successful");
            return ResponseEntity.ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("You have not logged in.");
        }
    }

    private void removeTokenFromResponse(HttpServletResponse response) {
        Cookie tokenCookie = new Cookie("token", null);
        tokenCookie.setMaxAge(0);
        tokenCookie.setHttpOnly(true);
        tokenCookie.setPath("/");
        response.addCookie(tokenCookie);
    }

    @ExceptionHandler(value = {BadCredentialsException.class,
            IllegalStateException.class, ResponseStatusException.class,
            HttpClientErrorException.class})
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    protected ErrorInfo handleConflict(RuntimeException e) {
        return new ErrorInfo(e);
    }

}
