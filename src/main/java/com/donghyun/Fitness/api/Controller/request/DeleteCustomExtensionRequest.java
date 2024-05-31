package com.donghyun.Fitness.api.Controller.request;

import jakarta.validation.constraints.NotNull;

public class DeleteCustomExtensionRequest {
    @NotNull
    private Long customExtensionId;
}
