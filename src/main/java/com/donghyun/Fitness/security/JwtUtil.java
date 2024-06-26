package com.donghyun.Fitness.security;

import com.donghyun.Fitness.api.Controller.response.MemberLoginResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Slf4j
@Component
public class JwtUtil {

    private final Key key;
    private final long ACCESS_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 24 * 365; // 1년
    private final long REFRESH_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 24 * 365 * 10; // 10년
    // TODO: 2024-06-26 (026) 만료시간 재 설정 

    private JwtUtil(@Value("${JWT_SECRET}") String secretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public MemberLoginResponse generateAllToken(String subject) {
        String accessToken = generateToken(subject, ACCESS_TOKEN_EXPIRE_TIME);
        String refreshToken = generateToken(subject, REFRESH_TOKEN_EXPIRE_TIME);

        return MemberLoginResponse.of(accessToken, refreshToken);
    }


    public String generateToken(String subject, long expTime) {
        Date now = new Date();
        Date expDate = new Date(now.getTime() + expTime);

        return Jwts.builder()
                .setSubject(subject)
                .setIssuer("dong")
                .setSubject(subject)
                .setAudience("me")
                .setExpiration(expDate)
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }




}
