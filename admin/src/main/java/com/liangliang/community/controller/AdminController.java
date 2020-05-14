package com.liangliang.community.controller;

import com.liangliang.community.api.CommonResult;
import com.liangliang.community.dto.AdminDetailInfoDto;
import com.liangliang.community.dto.AdminParam;
import com.liangliang.community.dto.LoginParam;
import com.liangliang.community.model.CAdmin;
import com.liangliang.community.security.utils.JwtTokenUtil;
import com.liangliang.community.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "AdminController", description = "用户管理模块")
@Controller
@RequestMapping("/api/admin")
public class AdminController {
    private final Logger logger = LoggerFactory.getLogger(AdminController.class);
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private AdminService adminService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @ApiOperation("登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody LoginParam loginParam, BindingResult result) {
        String token = adminService.login(loginParam.getUsername(), loginParam.getPassword());
        if (token == null) {
            return CommonResult.failed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("username", loginParam.getUsername());
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation("注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CAdmin> register(@RequestBody AdminParam adminParam, BindingResult result) {

        CAdmin admin = adminService.register(adminParam);
        if (admin == null) {
            return CommonResult.failed();
        }
        return CommonResult.success(admin);
    }

    @ApiOperation("登出功能")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult logout() {
        return CommonResult.success(null);
    }

    @ApiOperation(value = "个人信息")
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<AdminDetailInfoDto> getAdminInfo(Principal principal) {
        if (principal == null) {
            return CommonResult.unauthorized(null);
        }
        String username = principal.getName();
        AdminDetailInfoDto adminDetailInfo = adminService.getAdminDetailInfo(username);
        return CommonResult.success(adminDetailInfo);
    }

    @ApiOperation(value = "刷新token")
    @RequestMapping(value = "/refreshToken", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = adminService.refreshToken(token);
        if (refreshToken == null) {
            return CommonResult.failed("token已过期");
        }
        String username = jwtTokenUtil.getUserNameFromToken(refreshToken);
        Map<String, Object> tokenMap = new HashMap<>();
        tokenMap.put("username", username);
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

}
