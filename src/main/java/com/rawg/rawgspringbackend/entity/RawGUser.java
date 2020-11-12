package com.rawg.rawgspringbackend.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Builder
public class RawGUser {

    @Id
    @GeneratedValue
    private Long Id;
    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    private LocalDateTime registrationDate;

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "rawguser_user_liked_games",
          joinColumns = { @JoinColumn(name = "rawguser_id") },
    inverseJoinColumns = { @JoinColumn(name = "user_liked_games_id") })
    private Set<WishlistItem> userLikedGames;
}
