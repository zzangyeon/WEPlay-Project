package com.choi.weplay.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String nickname;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    List<Pick> picks;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    List<Review> reviews;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    List<Orders> orders;
}
