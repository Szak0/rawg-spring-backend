package com.rawg.rawgspringbackend.controller;
import com.rawg.rawgspringbackend.entity.RawGUser;
import com.rawg.rawgspringbackend.repository.UserRepository;
import com.rawg.rawgspringbackend.service.UserApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping
public class UserInfoController {

    @Autowired
    UserApiService authService;

    @Autowired
    UserRepository userRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/me")
    public ResponseEntity currentUser(HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Map<Object, Object> model = new HashMap<>();
        Optional<RawGUser> user = userRepository.findByEmail(authentication.getPrincipal().toString());
        RawGUser user1 = user.get();
        model.put("role", user1.getRoles());
        model.put("id", user1.getId());
        model.put("userName", user1.getUserName());
        model.put("userEmail", authentication.getPrincipal());
        model.put("registrationDate", user1.getRegistrationDate());
        return ResponseEntity.ok(model);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/list/users")
    public  List<RawGUser> allUsers() {
        return userRepository.findAll();
    }
}
