package com.donghyun.Fitness.api.Controller.test;

import com.donghyun.Fitness.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private final JwtUtil jwtUtil;

    @PostMapping
    public String test() {
        return jwtUtil.checkToken();
    }

}
