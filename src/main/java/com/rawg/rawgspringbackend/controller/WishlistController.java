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

import java.util.*;

@RestController
@RequestMapping
public class WishlistController {

    @Autowired
    GameApiService gameApiService;

    @Autowired
    UserRepository users;

    @Autowired
    UserRepository userRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/wishlist")
    public Set<WishlistItem> gameList() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<RawGUser> user = userRepository.findByEmail(authentication.getPrincipal().toString());
        return user.get().getUserLikedGames();
    }


    @RequestMapping(value = {"/api/wishlist/add"}, method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public ResponseEntity addToWishlist(WishlistItem item, String userEmail) {
        try {
            RawGUser user = users.findByEmail(userEmail)
                    .orElseThrow(() -> new UsernameNotFoundException("Email: " + userEmail + " not found"));
            gameApiService.addWishListItemToUser(item, user);
            Map<Object, Object> model = new HashMap<>();
            model.put("Game added to: ", user.getUserName());
            return ResponseEntity.ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException(e.getLocalizedMessage()   );
        }

    }
}
