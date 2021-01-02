package com.rawg.rawgspringbackend.controller;

import com.rawg.rawgspringbackend.entity.RawGUser;
import com.rawg.rawgspringbackend.entity.WishlistItem;
import com.rawg.rawgspringbackend.repository.UserRepository;
import com.rawg.rawgspringbackend.service.GameApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping
public class WishlistController {

    @Autowired
    GameApiService gameApiService;

    @Autowired
    UserRepository users;

    @Autowired
    UserRepository userRepository;

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @GetMapping("/api/wishlist")
    public Set<WishlistItem> gameList() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<RawGUser> user = userRepository.findByEmail(authentication.getPrincipal().toString());
        return user.get().getUserLikedGames();
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @PostMapping({"/api/wishlist/add"})
    public ResponseEntity addToWishlist(@RequestBody WishlistItem item) {
        try {
            RawGUser user = users.findByEmail(item.getUserEmail())
                    .orElseThrow(() -> new UsernameNotFoundException("Email: " + item.getUserEmail() + " not found"));
            gameApiService.addWishListItemToUser(item,user);
            Map<Object, Object> model = new HashMap<>();
            model.put("Game added to: ", user.getUserName());
            return ResponseEntity.ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException(e.getLocalizedMessage());
        }

    }

//    @RequestParam(value = "gameId") Long gameId,
//    @RequestParam(value = "name") String gameName,
//    @RequestParam(value = "background_image") String background_image,
//    @RequestParam(value = "released") String released,
//    @RequestParam(value = "rating") Double rating,
//    @RequestParam(value = "userEmail") String userEmail
}
