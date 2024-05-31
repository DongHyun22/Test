package com.donghyun.Fitness.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Slf4j
@Getter
@NoArgsConstructor
public class CustomExtension {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "custom_extension_id")
    private Long id;

    @Column(name = "custom_extension_name")
    private String name;

    @CreatedDate
    private LocalDateTime createdTime;

    @Builder
    public CustomExtension(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
