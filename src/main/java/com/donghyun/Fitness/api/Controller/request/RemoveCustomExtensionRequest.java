package com.donghyun.Fitness.api.Controller.request;

import com.donghyun.Fitness.domain.CustomExtension;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RemoveCustomExtensionRequest {
    @NotNull
    private Long customExtensionId;

}
