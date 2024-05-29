package com.donghyun.Fitness.api.Service;

import com.donghyun.Fitness.api.Repository.TestRepository;
import com.donghyun.Fitness.domain.Test;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;
    public List<Test> searchTests() {
        List<Test> tests;
        // TODO: 2024-05-29 (029) null 처리 
        tests = testRepository.findAll();

        return tests;
    }
}
