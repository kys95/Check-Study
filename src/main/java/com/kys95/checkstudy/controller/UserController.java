package com.kys95.checkstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/join")
    public String joinForm(){
        return "user/joinForm";
    }
}
