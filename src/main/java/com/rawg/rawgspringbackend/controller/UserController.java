package com.rawg.rawgspringbackend.controller;

import com.rawg.rawgspringbackend.entity.RawGUser;
import com.rawg.rawgspringbackend.service.RawGAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    RawGAPIService apiService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("api/register")
    @ResponseBody
    public RawGUser registerNewUser(@RequestBody RawGUser user) {
        return apiService.registerUser(user);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/login")
    @ResponseBody
    public RawGUser loginNewUser(@RequestBody RawGUser user) {
        List<RawGUser> userInfo = apiService.getUserInfo(user);
        return userInfo.get(0);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/api/user/{id}")
    public Optional<RawGUser> getGameById(@PathVariable Long id) {
        return apiService.getUserById(id);
    }

}
