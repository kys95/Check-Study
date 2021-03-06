package com.kys95.checkstudy.controller;

import com.kys95.checkstudy.config.auth.PrincipalDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping({"","/"})
    public String index(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        if (principalDetails != null) {
            String username = principalDetails.getUsername();
            Long userId = principalDetails.getUserId();
            model.addAttribute("username", username);
            model.addAttribute("userId", userId);
        }
        return "index";

    }
}
