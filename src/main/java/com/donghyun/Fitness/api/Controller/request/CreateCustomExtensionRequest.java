package com.donghyun.Fitness.api.Controller.request;

import com.donghyun.Fitness.domain.CustomExtension;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateCustomExtensionRequest {
    @NotBlank(message = "확장자를 입력해 주세요")
    @Size(max = 20, message = "확장자는 최대 20자리까지 입력할 수 있습니다.")
    private String customExtensionName;

    public CustomExtension toEntity() {
        return CustomExtension.builder()
                .name(this.customExtensionName)
                .build();
    }
}
