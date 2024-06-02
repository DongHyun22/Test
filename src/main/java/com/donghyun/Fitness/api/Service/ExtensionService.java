package com.donghyun.Fitness.api.Service;

import com.donghyun.Fitness.api.Controller.request.CreateCustomExtensionRequest;
import com.donghyun.Fitness.api.Controller.request.RemoveCustomExtensionRequest;
import com.donghyun.Fitness.api.Controller.request.SelectDefaultExtensionRequest;
import com.donghyun.Fitness.api.Controller.response.CustomExtensionResponse;
import com.donghyun.Fitness.api.Controller.response.DefaultExtensionResponse;
import com.donghyun.Fitness.api.Controller.response.ExtensionsResponse;
import com.donghyun.Fitness.api.Repository.CustomExtensionRepository;
import com.donghyun.Fitness.api.Repository.DefaultExtensionRepository;
import com.donghyun.Fitness.domain.CustomExtension;
import com.donghyun.Fitness.domain.DefaultExtension;
import com.sun.jdi.request.DuplicateRequestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
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

//    public ExtensionsResponse getExtensions() {
//        List<DefaultExtension> list = defaultExtensionRepository.findAll();
//        List<DefaultExtensionResponse> defaultExtensionResponseList = new ArrayList<>();
//        for(DefaultExtension d : list){
//             defaultExtensionResponseList.add(DefaultExtensionResponse.of(d));
//        }
//
//        List<CustomExtension> list1 = customExtensionRepository.findAll(Sort.by(Sort.Direction.DESC, "createdTime"));
//        List<CustomExtensionResponse> customExtensionResponseList = new ArrayList<>();
//        for(CustomExtension d : list1){
//            customExtensionResponseList.add(CustomExtensionResponse.of(d));
//        }
//
//        return new ExtensionsResponse(defaultExtensionResponseList, customExtensionResponseList);
//    }

    public List<DefaultExtensionResponse> getDefaultExtensions() {
        List<DefaultExtension> list = defaultExtensionRepository.findAll();
        List<DefaultExtensionResponse> defaultExtensionResponseList = new ArrayList<>();
        for(DefaultExtension d : list){
            defaultExtensionResponseList.add(DefaultExtensionResponse.of(d));
        }
        return defaultExtensionResponseList;
    }

    public List<CustomExtensionResponse> getCustomExtensions() {
        List<CustomExtension> list = customExtensionRepository.findAll(Sort.by(Sort.Direction.DESC, "createdTime"));
        List<CustomExtensionResponse> customExtensionResponseList = new ArrayList<>();
        for(CustomExtension d : list){
            customExtensionResponseList.add(CustomExtensionResponse.of(d));
        }
        return customExtensionResponseList;
    }

    public void createCustomExtension(CreateCustomExtensionRequest request) {
        // 최대 개수 200이상
        if(customExtensionRepository.count() >= 200) {
            throw new RuntimeException("커스텀 확장자는 최대 200개 까지 추가 가능합니다.");
        }

        if(customExtensionRepository.existsByName(request.getCustomExtensionName())) {
            throw new RuntimeException("이미 존재하는 확장자 입니다.");
        }

        CustomExtension customExtension = request.toEntity();

        customExtensionRepository.save(customExtension);
    }

    public void removeCustomExtension(RemoveCustomExtensionRequest request) {
        CustomExtension customExtension = customExtensionRepository.findById(request.getCustomExtensionId())
                .orElseThrow(() -> new NoSuchElementException());
        customExtensionRepository.delete(customExtension);
    }

    public void selectDefaultExtension(SelectDefaultExtensionRequest request) {
        DefaultExtension defaultExtension = defaultExtensionRepository.findById(request.getDefaultExtensionId())
                .orElseThrow(() -> new NoSuchElementException());
        defaultExtension.select(request.getState());
        defaultExtensionRepository.save(defaultExtension);
    }
}
