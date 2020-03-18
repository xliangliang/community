package com.liangliang.community.controller;

import com.liangliang.community.entity.User;
import com.liangliang.community.service.UserService;
import com.liangliang.community.utils.Md5Utils;
import com.liangliang.community.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(name = "/api/login", method = RequestMethod.POST)
    public String login(@RequestParam(name = "username") String username,
                        @RequestParam(name = "password") String password,
                        HttpServletResponse response,
                        Model model){
        User user = userService.userLogin(username, password);
        if (user == null) {
            model.addAttribute("error","用户名或密码错误");
        }
        String token = TokenUtils.getToken(user.getId());
        redisTemplate.opsForValue().set(token, user.getId());
        redisTemplate.opsForValue().set(String.valueOf(user.getId()), token);
        Cookie cookie = new Cookie("userinfo", token);
        response.addCookie(cookie);
        return "index";
    }
}
