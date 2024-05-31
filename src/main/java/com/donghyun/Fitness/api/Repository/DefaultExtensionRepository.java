package com.donghyun.Fitness.api.Repository;

import com.donghyun.Fitness.domain.DefaultExtension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefaultExtensionRepository extends JpaRepository<DefaultExtension, Long> {
}
