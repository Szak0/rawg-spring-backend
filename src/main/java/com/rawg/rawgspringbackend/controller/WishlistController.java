package com.rawg.rawgspringbackend.controller;

import com.rawg.rawgspringbackend.entity.WishlistItem;
import com.rawg.rawgspringbackend.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class WishlistController {

    @Autowired
    ApiService apiService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/api/wishlist")
    public List<WishlistItem> gameList() {
        return apiService.getWishlist();
    }

    @RequestMapping(value = {"/api/wishlist/add"}, method = RequestMethod.POST)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public void addToWishlist(WishlistItem item) {
        apiService.addWishListItem(item);
    }

}
