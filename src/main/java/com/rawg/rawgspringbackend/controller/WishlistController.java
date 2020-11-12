package com.rawg.rawgspringbackend.controller;

import com.rawg.rawgspringbackend.entity.RawGUser;
import com.rawg.rawgspringbackend.entity.WishlistItem;
import com.rawg.rawgspringbackend.repository.UserRepository;
import com.rawg.rawgspringbackend.service.GameApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public void addToWishlist(WishlistItem item, String userEmail) {
        RawGUser user = users.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("Email: " + userEmail + " not found"));
        gameApiService.addWishListItemToUser(item, user);
    }

}
