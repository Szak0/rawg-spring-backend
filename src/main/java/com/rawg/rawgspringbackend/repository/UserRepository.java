package com.rawg.rawgspringbackend.repository;
import com.rawg.rawgspringbackend.entity.RawGUser;
import com.rawg.rawgspringbackend.entity.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

public interface UserRepository extends JpaRepository<RawGUser, Long> {
    Optional<RawGUser> findByEmail(String email);
    Optional<RawGUser> findByUserName(String username);

    @Transactional
    @Modifying
    @Query("UPDATE RawGUser raw SET raw.likedGames = ?1 where raw.email = ?2")
    void updateUser(Set<WishlistItem> likedGamesSet, String userEmail );

}
