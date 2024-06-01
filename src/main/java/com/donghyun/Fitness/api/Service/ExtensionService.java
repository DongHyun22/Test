package com.donghyun.Fitness.api.Service;

import com.donghyun.Fitness.api.Controller.request.CreateCustomExtensionRequest;
import com.donghyun.Fitness.api.Controller.request.RemoveCustomExtensionRequest;
import com.donghyun.Fitness.api.Controller.response.CustomExtensionResponse;
import com.donghyun.Fitness.api.Controller.response.DefaultExtensionResponse;
import com.donghyun.Fitness.api.Controller.response.ExtensionsResponse;
import com.donghyun.Fitness.api.Repository.CustomExtensionRepository;
import com.donghyun.Fitness.api.Repository.DefaultExtensionRepository;
import com.donghyun.Fitness.domain.CustomExtension;
import com.donghyun.Fitness.domain.DefaultExtension;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExtensionService {
    private final DefaultExtensionRepository defaultExtensionRepository;
    private final CustomExtensionRepository customExtensionRepository;

    public ExtensionsResponse getExtensions() {
        List<DefaultExtension> list = defaultExtensionRepository.findAll();
        List<DefaultExtensionResponse> defaultExtensionResponseList = new ArrayList<>();
        for(DefaultExtension d : list){
             defaultExtensionResponseList.add(DefaultExtensionResponse.of(d));
        }

        List<CustomExtension> list1 = customExtensionRepository.findAll();
        List<CustomExtensionResponse> customExtensionResponseList = new ArrayList<>();
        for(CustomExtension d : list1){
            customExtensionResponseList.add(CustomExtensionResponse.of(d));
        }

        return new ExtensionsResponse(defaultExtensionResponseList, customExtensionResponseList);
    }

    public void createCustomExtension(CreateCustomExtensionRequest request) {
        log.debug("name : {}", request.getCustomExtensionName());
        customExtensionRepository.save(request.toEntity());
    }

    public void removeCustomExtension(RemoveCustomExtensionRequest request) {
        CustomExtension customExtension = customExtensionRepository.findById(request.getCustomExtensionId())
                .orElseThrow(() -> new NoSuchElementException());
        customExtensionRepository.delete(customExtension);
    }
}
