package com.donghyun.Fitness.api.Controller.request;

import com.donghyun.Fitness.domain.CustomExtension;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateCustomExtensionRequest {
    @NotBlank(message = "확장자를 입력해 주세요")
    private String customExtensionName;

    public CustomExtension toEntity() {
        return CustomExtension.builder()
                .name(this.customExtensionName)
                .build();
    }
}
