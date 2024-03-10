package com.polysoft.platfrom.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column private String userName;
    @Column private String email;
    @Column private String password;

    @ManyToMany(mappedBy = "articlesTags", fetch = FetchType.LAZY)
    private Set<Interests> userInterests;
}

