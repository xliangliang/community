package com.liangliang.community.controller;

import com.liangliang.community.api.CommonResult;
import com.liangliang.community.dto.PublishParam;
import com.liangliang.community.model.CAdmin;
import com.liangliang.community.service.AdminService;
import com.liangliang.community.service.PublishService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * @author Liangliang
 * @date 2020/4/23
 * @desc
 */
@Api(tags = "PublishController", description = "用户发布模块")
@Controller
@RequestMapping("/api")
public class PublishController {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Autowired
    private PublishService publishService;
    @Autowired
    private AdminService adminService;


    @ApiOperation("问题发布")
    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult pulish(@RequestBody PublishParam publishParam, Principal principal) {
        if (principal == null) {
            return CommonResult.unauthorized(null);
        }
        String username = principal.getName();
        CAdmin admin = adminService.getAdminByUsername(username);
        Integer result = publishService.addQuestion(admin.getId(), publishParam);
        if (result == 0) {
            return CommonResult.failed("发布失败");
        }
        return CommonResult.success("发布成功");
    }
}
