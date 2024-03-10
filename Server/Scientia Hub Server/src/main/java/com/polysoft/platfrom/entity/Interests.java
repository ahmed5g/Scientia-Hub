package com.polysoft.platfrom.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Interests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column private String tag;
    private String description;

    @ManyToMany(mappedBy = "userInterests", fetch = FetchType.LAZY)
    private Set<ArticlesTags> userInterests;
}
