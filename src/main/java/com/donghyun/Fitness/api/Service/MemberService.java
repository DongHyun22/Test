package com.donghyun.Fitness.api.Service;

import com.donghyun.Fitness.api.Controller.request.MemberLoginRequest;
import com.donghyun.Fitness.api.Controller.response.MemberLoginResponse;
import com.donghyun.Fitness.api.Repository.MemberRepository;
import com.donghyun.Fitness.domain.Member;
import com.donghyun.Fitness.security.JwtUtil;
import com.donghyun.Fitness.security.KisUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    private final JwtUtil jwtUtil;
    private final KisUtil kisUtil;

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

    public Long joinMember(JSONObject jsonObject) throws JSONException {
        // TODO: 2024-07-23 (023) joinMember가 아닌 sns로그인 함수로 이름 변경
        
        String email = jsonObject.getString("email");
//        if(memberRepository.existsByEmail()) {
//            return memberRepository.findByEmail(email).getId();
//        }
        // TODO: 2024-07-23 (023) 기존의 sns로 로그인한 계정이 있을때와 처음 sns로그인 할 때 분리 ** 

        int year = jsonObject.getInt("birthyear");
        String birth = jsonObject.getString("birthday");
        int month = Integer.parseInt(birth.substring(0, 2));
        int day = Integer.parseInt(birth.substring(3, 5));
        int age = calculateAge(year, month, day);
        log.debug("age: {}", age);

        Member member = Member.builder()
                .age(age)
                .email(email)
                .name(jsonObject.getString("name"))
                .password(jsonObject.getString("mobile"))
                .build();
        // TODO: 2024-07-23 (023) sns계정 회원가입 다시 구현 

        return memberRepository.save(member).getId();
    }

    public String kisLoginMember() throws IOException {
        String kisToken = kisUtil.generateKisToken();
        return kisToken;
    }


    /*
        Business Logic
     */

    public static int calculateAge(int year, int month, int day) {
        // TODO: 2024-07-23 (023) 나이 계산 함수 리팩토링 
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = LocalDate.of(year, month, day); // 생일을 1월 1일로 설정
        return Period.between(birthDate, currentDate).getYears();
    }

}
