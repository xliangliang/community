package com.liangliang.community.controller;

import com.liangliang.community.entity.User;
import com.liangliang.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletRequest;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(name = "/api/login", method = RequestMethod.POST)
    public String login(@RequestParam(name = "username") String username,
                        @RequestParam(name = "password") String password,
                        ServletRequest request,
                        Model model){
        User user = userService.userLogin(username, password);
        if (user == null) {
            model.addAttribute("error","用户名或密码错误");
        }
        return "index";
    }
}
