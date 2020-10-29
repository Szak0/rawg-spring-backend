package com.rawg.rawgspringbackend.repository;

import com.rawg.rawgspringbackend.entity.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WishlistItemRepository extends JpaRepository<WishlistItem, Long> {

}
