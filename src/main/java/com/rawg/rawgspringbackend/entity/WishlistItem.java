package com.rawg.rawgspringbackend.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Builder
public class WishlistItem {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private Long gameId;
    private String name;
    private String background_image;
    private String released;
    private double rating;
    @Transient
    private String userEmail;



    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JsonIgnore
    private Set<RawGUser> usersWhoLiked;

}
