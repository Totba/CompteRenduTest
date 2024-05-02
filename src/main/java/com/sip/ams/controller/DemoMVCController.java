package com.sip.ams.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoMVCController {
    @GetMapping("/")
    public String displayMessage() {
        return "Hello Ynov";
    }

}
