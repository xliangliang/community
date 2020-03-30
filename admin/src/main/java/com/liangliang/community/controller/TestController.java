package com.liangliang.community.controller;

import com.liangliang.community.utils.GetIpAddressUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {
    @GetMapping("/test")
    public String test(HttpServletRequest request) {
        System.out.println("Hello");
        String ip = GetIpAddressUtils.getIpAddress(request);
        System.out.println(ip);
        return "index";
    }
}
