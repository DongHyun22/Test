package com.donghyun.Fitness.api.Controller;

import com.donghyun.Fitness.api.Controller.request.CreateCustomExtensionRequest;
import com.donghyun.Fitness.api.Controller.request.RemoveCustomExtensionRequest;
import com.donghyun.Fitness.api.Controller.request.SelectDefaultExtensionRequest;
import com.donghyun.Fitness.api.Service.ExtensionService;
import com.donghyun.Fitness.config.ExtensionForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ExtensionController {
    private final ExtensionService extensionService;

    /**
     * 고정 확장자와 커스텀 확장자 전체 조회 ( 커스텀 확장자 최신 순 정렬 )
     *
     * @return 고정 확장자 리스트와 커스텀 확장자 리스트
     */

//    @GetMapping("/")
//    public ExtensionsResponse getExtensions() {
//        ExtensionsResponse extensionsResponse = extensionService.getExtensions();
//
//        return extensionsResponse;
//    }
    @GetMapping("/")
    public String getExtensions(Model model) {

        model.addAttribute("defaultExtensions", extensionService.getDefaultExtensions());
        model.addAttribute("customExtensions", extensionService.getCustomExtensions());
        model.addAttribute("extensionForm", new ExtensionForm());
        return "index";
    }


    /**
     * 고정 확장자 체크 or 체크해제
     */
    @PostMapping("/select")
    public String selectDefaultExtension(@RequestBody SelectDefaultExtensionRequest request) {
        extensionService.selectDefaultExtension(request);
        return "redirect:/";
    }

    /**
     * 커스텀 확장자 추가 ( 중복 체크, 최대 개수 200개 제한 )
     */
//    @PostMapping("/save")
//    public String createCustomExtension(@RequestBody CreateCustomExtensionRequest request) {
//        extensionService.createCustomExtension(request);
//        return "완료";
//    }
    @PostMapping("/save")
    public String createCustomExtension(@Valid CreateCustomExtensionRequest request, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("errorMessage", bindingResult.getFieldError("customExtensionName").getDefaultMessage());
            model.addAttribute("defaultExtensions", extensionService.getDefaultExtensions());
            model.addAttribute("customExtensions", extensionService.getCustomExtensions());
            model.addAttribute("extensionForm", new ExtensionForm());
            return "index";
        }

        try {
            extensionService.createCustomExtension(request);
            return "redirect:/";
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("defaultExtensions", extensionService.getDefaultExtensions());
            model.addAttribute("customExtensions", extensionService.getCustomExtensions());
            model.addAttribute("extensionForm", new ExtensionForm());

            return "index";
        }
    }

    /**
     * 커스텀 확장자 삭제
     */
//    @PostMapping("/delete")
//    public String removeCustomExtension(@RequestBody RemoveCustomExtensionRequest request) {
//        extensionService.removeCustomExtension(request);
//        return "완료";
//    }
    @PostMapping("/delete")
    public String removeExtension(RemoveCustomExtensionRequest request, Model model) {

        extensionService.removeCustomExtension(request);
//        model.addAttribute("defaultExtensions", extensionService.getDefaultExtensions());
//        model.addAttribute("customExtensions", extensionService.getCustomExtensions());
//        model.addAttribute("extensionForm", new ExtensionForm());
        return "redirect:/";
    }

}


