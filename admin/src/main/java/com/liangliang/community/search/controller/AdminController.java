package com.liangliang.community.search.controller;

import com.liangliang.community.api.CommonResult;
import com.liangliang.community.dto.LoginParam;
import com.liangliang.community.dto.RegisterParam;
import com.liangliang.community.entity.User;
import com.liangliang.community.model.UserAdmin;
import com.liangliang.community.search.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<User> login(@RequestBody LoginParam loginParam) {
        User user = userService.userLogin(loginParam.getUsername(), loginParam.getPassword());
        if (user == null) {
            return CommonResult.unauthorized(null);
        }
        return CommonResult.success(user);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<UserAdmin> register(@RequestBody RegisterParam registerParam) {
        UserAdmin userAdmin = userService.register(registerParam);
        if (userAdmin == null) {
            return CommonResult.failed();
        }
        return CommonResult.success(userAdmin);
    }
}
