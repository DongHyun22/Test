package com.donghyun.Fitness.api.Repository;

import com.donghyun.Fitness.domain.CustomExtension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomExtensionRepository extends JpaRepository<CustomExtension, Long> {
    boolean existsByName(String customExtensionName);
}
