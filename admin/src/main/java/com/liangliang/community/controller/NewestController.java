package com.liangliang.community.controller;

import com.liangliang.community.api.CommonPage;
import com.liangliang.community.api.CommonResult;
import com.liangliang.community.model.CPublish;
import com.liangliang.community.service.NewestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @ApiOperation(value = "获取所有发布")
    @RequestMapping(value = "/newest", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<CPublish>> list(@RequestParam(value = "pageNum", defaultValue = "10") Integer pageNum,
                                                   @RequestParam(value = "pageSize", defaultValue = "1") Integer pageSize) {
        List<CPublish> list = newestService.list(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(list));
    }
}
