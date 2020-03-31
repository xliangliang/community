package com.liangliang.community.search.controller;

import com.liangliang.community.api.CommonResult;
import com.liangliang.community.search.service.EsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Liangliang
 * @date 2020/3/31
 * @desc
 */
@Controller
@RequestMapping("/api")
public class EsUserController {

    @Autowired
    private EsUserService esUserService;

    @RequestMapping(value = "/userTotalNum", method = RequestMethod.GET)
    public CommonResult<Integer> userTotalNum() {
        int count = esUserService.userTotalNum();
        return CommonResult.success(count);
    }
}
