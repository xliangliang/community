package com.liangliang.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @GetMapping("/hello")
    @ResponseBody
    public String index() {
        System.out.println("Hello");
        return "Hello,world";
    }
}
