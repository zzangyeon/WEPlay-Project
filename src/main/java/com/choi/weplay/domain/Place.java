package com.choi.weplay.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String region;
    private String category;
    private String thumbnail;
//    @Column(nullable = false)
    private String name;
    private String content;
    private String tel;
    private String info;
    private String menu;
    private String address;
    private boolean partner;

    @OneToMany(mappedBy = "place",fetch = FetchType.LAZY)
    private List<Item> items;

}
