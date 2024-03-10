package com.polysoft.platfrom.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class ArticlesTags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    private Interests interests; // Renamed from "tags"


    //TODO - CORRECT RELATIONSHIP
    // RENAME THE CLASS USER-preferences
    // implements recommendation engine (: strategy, : observer)
    // modules : 1- user management and recommendation engine
    //          2- content and search management (web scrapper) (search: strategy )
    //          3- AI powered module (chat bot , ai search optimization for article-user recommendation)
    //DESIGN PATTERN : strategy , observer


    // Update constructor to use the renamed field
    public ArticlesTags(Users users, Interests interests) {
        this.users = users;
        this.interests = interests;
    }
}

