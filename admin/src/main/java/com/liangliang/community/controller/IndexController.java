package com.liangliang.community.controller;

import com.liangliang.community.api.CommonResult;
import com.liangliang.community.dto.CityDto;
import com.liangliang.community.model.CCity;
import com.liangliang.community.service.CityService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(value = "IndexController", description = "主页模块")
@Controller
@RequestMapping("/api/index")
public class IndexController {

    private final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private CityService cityService;

    @GetMapping("/hello")
    @ResponseBody
    public String index() {
        logger.info("username:{}", "xliangliang");
        return "Hello,world";
    }

    @GetMapping("/city/{id}")
    @ResponseBody
    public CommonResult getTreeCity(@PathVariable("id") Integer id) {
        List<CityDto> list = cityService.getTreeCity(id);
        return CommonResult.success(list);
    }

    @GetMapping("/getCity/{id}")
    @ResponseBody
    public CommonResult getCity(@PathVariable("id") Integer id){
        CCity city = cityService.fingOne(id);
        System.out.println();
        return CommonResult.success(city);
    }
}
