//package com.donghyun.Fitness.thymeleaf;
//
//import com.donghyun.Fitness.api.Controller.response.ExtensionsResponse;
//import com.donghyun.Fitness.api.Service.ExtensionService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.List;
//
//@Controller
//@RequiredArgsConstructor
//public class HomeController {
//    private final ExtensionService extensionService;
//    @GetMapping("/")
//    public String samplePage(Model model) {
//        ExtensionsResponse extensionsResponse = extensionService.getExtensions();
//        model.addAttribute("pageTitle", extensionsResponse.getCustomExtensionResponses().get(0).getCustomExtensionName());
//        model.addAttribute("items", extensionsResponse.getCustomExtensionResponses());
//        return "index"; // Thymeleaf template name (sample.html)
//    }
//}
