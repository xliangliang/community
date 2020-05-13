package com.liangliang.community.controller;

import com.liangliang.community.api.CommonPage;
import com.liangliang.community.api.CommonResult;
import com.liangliang.community.dto.NewestDto;
import com.liangliang.community.model.CAdmin;
import com.liangliang.community.service.AdminService;
import com.liangliang.community.service.NewestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;

/**
 * @author Liangliang
 * @date 2020/4/27
 * @desc
 */
@Api(value = "NewestController", description = "主页最新模块")
@Controller
@RequestMapping("/api/index")
public class NewestController {

    @Autowired
    private NewestService newestService;
    @Autowired
    private AdminService adminService;

    @ApiOperation(value = "获取所有发布")
    @RequestMapping(value = "/newest", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<NewestDto>> list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                    @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        List<NewestDto> list = newestService.list(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation(value = "获取用户所有问题")
    @RequestMapping(value = "/adminQuestion", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<NewestDto>> getAdminQuestion(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                Principal principal) {
        if (principal == null) {
            return CommonResult.unauthorized(null);
        }
        String username = principal.getName();
        CAdmin admin = adminService.getAdminByUsername(username);
        List<NewestDto> list = newestService.getUserQuestion(admin.getId(), pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation(value = "根据问题id获取问题")
    @RequestMapping(value = "/getQuestion", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<NewestDto> getQuestionById(@RequestParam(value = "questionId") Integer questionId) {
        NewestDto newestDto = newestService.getQuestionById(questionId);
        return CommonResult.success(newestDto);
    }
}
