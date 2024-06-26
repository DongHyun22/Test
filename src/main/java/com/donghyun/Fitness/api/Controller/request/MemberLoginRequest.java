package com.donghyun.Fitness.api.Controller.request;

import lombok.Data;

@Data
public class MemberLoginRequest {
    private String memberEmail;
    private String memberPassword;
}
