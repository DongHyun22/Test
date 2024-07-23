package com.donghyun.Fitness.api.Repository;

import com.donghyun.Fitness.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);

    // TODO: 2024-07-23 (023) 존재 여부 함수 만들기 
}
