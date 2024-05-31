package com.donghyun.Fitness.api.Controller.response;

import com.donghyun.Fitness.config.State;
import com.donghyun.Fitness.domain.DefaultExtension;
import lombok.Builder;
import lombok.Data;

@Data
public class DefaultExtensionResponse {
    private Long defaultExtensionId;
    private String defaultExtensionName;
    private State state;

    @Builder
    public DefaultExtensionResponse(Long defaultExtensionId, String defaultExtensionName, State state) {
        this.defaultExtensionId = defaultExtensionId;
        this.defaultExtensionName = defaultExtensionName;
        this.state = state;
    }

    public static DefaultExtensionResponse of(DefaultExtension defaultExtension) {
        return DefaultExtensionResponse.builder()
                .defaultExtensionId(defaultExtension.getId())
                .defaultExtensionName(defaultExtension.getName())
                .state(defaultExtension.getState())
                .build();
    }
}
