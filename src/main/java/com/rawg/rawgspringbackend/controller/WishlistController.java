package com.rawg.rawgspringbackend.controller;

import com.rawg.rawgspringbackend.entity.WishlistItem;
import com.rawg.rawgspringbackend.service.RawGAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class WishlistController {

    @Autowired
    RawGAPIService rawGAPIService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/api/wishlist")
    public List<WishlistItem> gameList() {
        System.out.println(rawGAPIService.getWishlist());
        return rawGAPIService.getWishlist();
    }

}
