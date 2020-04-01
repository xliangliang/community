package com.liangliang.community.controller;

import com.liangliang.community.api.CommonResult;
import com.liangliang.community.dto.LoginParam;
import com.liangliang.community.dto.RegisterParam;
import com.liangliang.community.entity.User;
import com.liangliang.community.service.AdminService;
import com.liangliang.community.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(tags = "AdminController", description = "用户管理模块")
@Controller
@RequestMapping("/api")
public class AdminController {

    private final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @ApiOperation("登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<String> login(@RequestBody LoginParam loginParam) {
        String token = adminService.login(loginParam);
        if (token == null) {
            return CommonResult.unauthorized(null);
        }
        return CommonResult.success(token);
    }

    @ApiOperation("注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<User> register(@RequestBody RegisterParam registerParam) {
        User user = adminService.register(registerParam);
        if (user == null) {
            return CommonResult.failed();
        }
        return CommonResult.success(user);
    }

}
