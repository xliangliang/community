package com.liangliang.community.controller;

import com.liangliang.community.utils.GetIpAddressUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {
    @GetMapping("/test")
    public String test(HttpServletRequest request) {
        System.out.println("Hello");
        String ip = GetIpAddressUtils.getIpAddress(request);
        System.out.println(ip);
        return "index";
    }
}
