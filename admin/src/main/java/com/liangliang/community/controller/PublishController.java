package com.liangliang.community.controller;

import com.liangliang.community.api.CommonResult;
import com.liangliang.community.dto.PublishParam;
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


    @ApiOperation("问题发布")
    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult pulish(@RequestBody PublishParam publishParam,
                               HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        Integer result = publishService.addQuestion(token, publishParam);
        if (result == 0) {
            return CommonResult.failed("发布失败");
        }
        return CommonResult.success("发布成功");
    }
}
