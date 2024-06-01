package com.donghyun.Fitness.api.Controller;

import com.donghyun.Fitness.api.Controller.request.CreateCustomExtensionRequest;
import com.donghyun.Fitness.api.Controller.request.RemoveCustomExtensionRequest;
import com.donghyun.Fitness.api.Controller.request.SelectDefaultExtensionRequest;
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
     * 고정 확장자와 커스텀 확장자 전체 조회 ( 고정 확장자 ID순 오름차순 정렬, 커스텀 확장자 최신 순 정렬 )
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
    @PostMapping("/select")
    public String selectDefaultExtension(@RequestBody SelectDefaultExtensionRequest request) {
        extensionService.selectDefaultExtension(request);
        return "완료";
    }

    /**
     * 커스텀 확장자 추가 ( 중복 체크, 최대 개수 200개 제한 )
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
