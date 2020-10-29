package com.rawg.rawgspringbackend.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Builder
public class WishlistItem {

    @Id
    private Long id;
    @Column(nullable = false)
    private String name;
    private String background_image;
    private String released;
    private String author;
    private double rating;


}
