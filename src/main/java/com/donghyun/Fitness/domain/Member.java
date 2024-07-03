package com.donghyun.Fitness.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Slf4j
@Getter
@NoArgsConstructor
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String email;

    private String password;

    private String name;

    private int age;

    @Builder
    public Member(Long id, String email, String password, String name, int age) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
    }
}
