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

    @Column(name = "member_email")
    private String email;

    @Column(name = "member_password")
    private String password;

    @Builder
    public Member(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
