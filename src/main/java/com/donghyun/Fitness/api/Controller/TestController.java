package com.donghyun.Fitness.api.Controller;

import com.donghyun.Fitness.api.Service.TestService;
import com.donghyun.Fitness.domain.Test;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @GetMapping("/")
    public String test() {
        List<Test> tests = testService.searchTests();
        Test t = tests.get(tests.size() - 1);
        return t.getId() + " " + t.getName();
    }

}
