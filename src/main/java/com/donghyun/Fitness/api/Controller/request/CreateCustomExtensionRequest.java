package com.donghyun.Fitness.api.Controller.request;

import com.donghyun.Fitness.domain.CustomExtension;
import jakarta.validation.constraints.NotNull;

public class CreateCustomExtensionRequest {
    @NotNull
    private String customExtensionName;

    public CustomExtension toEntity() {
        return CustomExtension.builder()
                .name(this.customExtensionName)
                .build();
    }
}