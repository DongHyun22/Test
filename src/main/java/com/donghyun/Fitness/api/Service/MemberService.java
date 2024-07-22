package com.donghyun.Fitness.api.Service;

import com.donghyun.Fitness.api.Controller.request.MemberLoginRequest;
import com.donghyun.Fitness.api.Controller.response.MemberLoginResponse;
import com.donghyun.Fitness.api.Repository.MemberRepository;
import com.donghyun.Fitness.domain.Member;
import com.donghyun.Fitness.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {
    private final JwtUtil jwtUtil;
    private final MemberRepository memberRepository;

    public MemberLoginResponse loginMember(MemberLoginRequest request) {

        Member member = memberRepository.findByEmail(request.getMemberEmail());

        // TODO: 2024-07-22 (022) 멤버 null 예외 처리 

        if(request.getMemberPassword().equals(member.getPassword())) {
            log.debug("Login_success: {}", request.getMemberEmail());
        }

        MemberLoginResponse response = jwtUtil.generateAllToken(request.getMemberEmail());
        log.debug("response:{}", response);

        return response;
    }

}
