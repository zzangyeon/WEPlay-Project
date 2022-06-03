package com.choi.weplay.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

    //@Column(nullable = false) // jpa - table 생성시 제약 설정하는 어노테이션
    @NotBlank // 객체의 유효성 검사 validation check
    //@Size(min = ,max =)
    private String name;
    private String content;
    private String tel;
    private String info;
    private String menu;
    private String address;
    private boolean partner;

    @OneToMany(mappedBy = "place",fetch = FetchType.LAZY)
    private List<Item> items;

    @OneToMany(mappedBy = "place",fetch = FetchType.LAZY)
    private List<Review> reviews;

}
