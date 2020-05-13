package com.liangliang.community.controller;

import com.liangliang.community.api.CommonPage;
import com.liangliang.community.api.CommonResult;
import com.liangliang.community.dto.CommentParam;
import com.liangliang.community.dto.CommentResult;
import com.liangliang.community.model.CAdmin;
import com.liangliang.community.model.CComment;
import com.liangliang.community.service.AdminService;
import com.liangliang.community.service.CommentSerivce;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * created by Liangliang on 2020/5/12
 */
@Api(tags = "CommentController", description = "回复模块")
@Controller
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private CommentSerivce commentSerivce;

    @ApiOperation("添加回复")
    @RequestMapping(value = "/addComment", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult addComment(@RequestBody CommentParam commentParam, Principal principal) {
        if (principal == null) {
            return CommonResult.unauthorized(null);
        }
        String username = principal.getName();
        CAdmin admin = adminService.getAdminByUsername(username);
        CComment comment = commentSerivce.addComment(admin.getId(), commentParam);
        if (comment == null) {
            return CommonResult.failed();
        }
        return CommonResult.success(comment);
    }

    @ApiOperation("获取所有回复")
    @RequestMapping(value = "/getAllComment", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage> getAllComment(@RequestParam(value = "questionId") Long questionId,
                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        List<CommentResult> list = commentSerivce.getAllComment(questionId, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(list));
    }
}
