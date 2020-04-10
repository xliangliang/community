package com.liangliang.community.controller;

import com.liangliang.community.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    private final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private AdminService adminService;

    @GetMapping("/hello")
    @ResponseBody
    public String index() {
        String username = "xliangliang";
//        adminService.testAspect();
        logger.info("username:{}", username);
        return "Hello,world";
    }
}
