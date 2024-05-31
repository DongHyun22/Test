package com.donghyun.Fitness.api.Controller;

import com.donghyun.Fitness.api.Controller.request.CreateCustomExtensionRequest;
import com.donghyun.Fitness.api.Controller.request.RemoveCustomExtensionRequest;
import com.donghyun.Fitness.api.Controller.response.ExtensionsResponse;
import com.donghyun.Fitness.api.Service.ExtensionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ExtensionController {
    private final ExtensionService extensionService;

    /**
     * 고정 확장자와 커스텀 확장자 전체 조회
     * @return 고정 확장자 리스트와 커스텀 확장자 리스트
     */

    @GetMapping("/")
    public ExtensionsResponse getExtensions() {
        ExtensionsResponse extensionsResponse = extensionService.getExtensions();

        return extensionsResponse;
    }

    /**
     * 고정 확장자 체크 or 체크해제
     */

    /**
     * 커스텀 확장자 추가 ( 중복 체크 )
     */
    @PostMapping("/save")
    public String createCustomExtension(@RequestBody CreateCustomExtensionRequest request) {
        extensionService.createCustomExtension(request);
        return "완료";
    }

    /**
     * 커스텀 확장자 삭제
     */
    @PostMapping("/delete")
    public String removeCustomExtension(@RequestBody RemoveCustomExtensionRequest request) {
        extensionService.removeCustomExtension(request);
        return "완료";
    }
}
