package com.rawg.rawgspringbackend.controller;
import com.rawg.rawgspringbackend.entity.RawGUser;
import com.rawg.rawgspringbackend.repository.UserRepository;
import com.rawg.rawgspringbackend.service.UserApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/api/me")
    public ResponseEntity currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);
        Map<Object, Object> model = new HashMap<>();
        Optional<RawGUser> user = userRepository.findByEmail(authentication.getPrincipal().toString());
        RawGUser user1 = user.orElse(null);
        assert user1 != null;
        model.put("role", user1.getRoles());
        model.put("id", user1.getId());
        model.put("userName", user1.getUserName());
        model.put("userEmail", authentication.getPrincipal());
        model.put("registrationDate", user1.getRegistrationDate());
        return ResponseEntity.ok(model);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/api/list/users")
    public  List<RawGUser> allUsers() {
        return userRepository.findAll();
    }
}
