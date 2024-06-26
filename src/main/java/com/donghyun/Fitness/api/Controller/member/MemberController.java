package com.donghyun.Fitness.api.Controller.member;

import com.donghyun.Fitness.api.Controller.request.MemberLoginRequest;
import com.donghyun.Fitness.api.Controller.response.MemberLoginResponse;
import com.donghyun.Fitness.api.Service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    public final MemberService memberService;

    @PostMapping("/login")
    public MemberLoginResponse loginMember(@RequestBody MemberLoginRequest request) {
        return memberService.loginMember(request);
    }

}
