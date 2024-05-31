package com.donghyun.Fitness.domain;

import com.donghyun.Fitness.config.State;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Slf4j
@Getter
@NoArgsConstructor
@Table(name = "default_extension")
public class DefaultExtension {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "default_extension_id")
    private Long id;

    @Column(name = "default_extension_name")
    private String name;

    @Enumerated(EnumType.STRING)
    private State state;

    @Builder
    public DefaultExtension(Long id, String name, State state) {
        this.id = id;
        this.name = name;
        this.state = state;
    }
}
