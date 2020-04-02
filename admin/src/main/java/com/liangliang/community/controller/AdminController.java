package com.liangliang.community.controller;

import com.liangliang.community.api.CommonResult;
import com.liangliang.community.dto.LoginParam;
import com.liangliang.community.dto.RegisterParam;
import com.liangliang.community.model.CAdmin;
import com.liangliang.community.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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
    public CommonResult<CAdmin> login(@RequestBody LoginParam loginParam) {
        CAdmin user = adminService.login(loginParam);
        if (user == null) {
            return CommonResult.failed("用户名或密码错误");
        }
        return CommonResult.success(user);
    }

    @ApiOperation("注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CAdmin> register(@RequestParam("username") String username, @RequestParam("password") String password) {
        RegisterParam registerParam = new RegisterParam();
        registerParam.setUsername(username);
        registerParam.setPassword(password);
        registerParam.setCreateTime(new Date());
        int count = adminService.register(registerParam);
        if (count == 0 || count == -1) {
            return CommonResult.failed();
        }
        return CommonResult.success(null);
    }

}
