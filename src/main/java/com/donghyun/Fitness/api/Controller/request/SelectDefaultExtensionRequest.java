package com.donghyun.Fitness.api.Controller.request;

import com.donghyun.Fitness.config.State;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SelectDefaultExtensionRequest {
    @NotNull
    private Long defaultExtensionId;

    @NotNull
    private State state;

}
