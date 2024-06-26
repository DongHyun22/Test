package com.donghyun.Fitness.api.Service;

import com.donghyun.Fitness.api.Controller.request.MemberLoginRequest;
import com.donghyun.Fitness.api.Controller.response.MemberLoginResponse;
import com.donghyun.Fitness.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {
    private final JwtUtil jwtUtil;

    public MemberLoginResponse loginMember(MemberLoginRequest request) {
        MemberLoginResponse response = jwtUtil.generateAllToken(request.getMemberEmail());
        log.debug("response:{}", response);
        return response;
    }

}
