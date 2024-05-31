package com.donghyun.Fitness.api.Controller.request;

import jakarta.validation.constraints.NotNull;

public class RemoveCustomExtensionRequest {
    @NotNull
    private Long customExtensionId;
}
