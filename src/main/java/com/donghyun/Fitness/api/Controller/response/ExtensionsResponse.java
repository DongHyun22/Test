package com.donghyun.Fitness.api.Controller.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class ExtensionsResponse {
    private List<DefaultExtensionResponse> defaultExtensionResponses;
    private List<CustomExtensionResponse> customExtensionResponses;

    @Builder
    public ExtensionsResponse(List<DefaultExtensionResponse> defaultExtensionResponses, List<CustomExtensionResponse> customExtensionResponses) {
        this.defaultExtensionResponses = defaultExtensionResponses;
        this.customExtensionResponses = customExtensionResponses;
    }
}
