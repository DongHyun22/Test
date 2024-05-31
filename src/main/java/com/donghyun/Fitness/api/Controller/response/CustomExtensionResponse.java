package com.donghyun.Fitness.api.Controller.response;

import com.donghyun.Fitness.domain.CustomExtension;
import lombok.Builder;
import lombok.Data;

@Data
public class CustomExtensionResponse {
    private Long customExtensionId;
    private String customExtensionName;

    @Builder
    public CustomExtensionResponse(Long customExtensionId, String customExtensionName) {
        this.customExtensionId = customExtensionId;
        this.customExtensionName = customExtensionName;
    }

    public static CustomExtensionResponse of(CustomExtension customExtension) {
        return CustomExtensionResponse.builder()
                .customExtensionId(customExtension.getId())
                .customExtensionName(customExtension.getName())
                .build();
    }
}
