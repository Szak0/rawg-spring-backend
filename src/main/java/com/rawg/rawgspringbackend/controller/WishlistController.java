package com.rawg.rawgspringbackend.controller;

import com.rawg.rawgspringbackend.entity.WishlistItem;
import com.rawg.rawgspringbackend.service.GameApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class WishlistController {

    @Autowired
    GameApiService gameApiService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/api/wishlist")
    public List<WishlistItem> gameList() {
        return gameApiService.getWishlist();
    }

    @RequestMapping(value = {"/api/wishlist/add"}, method = RequestMethod.POST)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public void addToWishlist(WishlistItem item) {
        gameApiService.addWishListItem(item);
    }

}
