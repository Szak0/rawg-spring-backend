package com.rawg.rawgspringbackend.repository;

import com.rawg.rawgspringbackend.entity.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WishlistRepository extends JpaRepository<WishlistItem, Long> {
    Optional<WishlistItem> findByGameId(Long id);
}
