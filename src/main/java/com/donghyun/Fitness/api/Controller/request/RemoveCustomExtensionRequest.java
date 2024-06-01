package com.donghyun.Fitness.api.Controller.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RemoveCustomExtensionRequest {
    @NotNull
    private Long customExtensionId;

}
