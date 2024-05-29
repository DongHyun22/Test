package com.donghyun.Fitness.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisHash;

@Entity
@Slf4j
@Getter
@NoArgsConstructor
public class Test {
    @Id
    private Long id;
    private String name;

    @Builder
    public Test(Long id, String name) {
        this.id = id;
        this.name = name;
    }


}
