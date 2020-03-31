package com.liangliang.community.controller;

import com.liangliang.community.provider.GithubProvider;
import com.liangliang.community.service.UserService;
import com.liangliang.community.utils.GetIpAddressUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {
    private String client_id;
    private String client_secret;
    private String redirect_uri;
    @Autowired
    private GithubProvider githubProvider;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    @ResponseBody
    public String index(){
        return "Hello,world";
    }

    @GetMapping("/callback")
    public String callBack(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request,
                           HttpServletResponse response){
        String ip = GetIpAddressUtils.getIpAddress(request);
        System.out.println(ip);
        /*AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(client_id);
        accessTokenDTO.setClient_secret(client_secret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirect_uri);
        accessTokenDTO.setState(state);
        String str = githubProvider.getAccessToken(accessTokenDTO);
        String access_token = str.split("&")[0].split("=")[1];
        GithubUser githubUser = githubProvider.getUserInfo(access_token);
        if (githubUser != null) {
            User user = new User();
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setName(githubUser.getLogin());
            user.setToken(UUID.randomUUID().toString());
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userService.addUser(user);
            //写session
            //request.getSession().setAttribute("user",user);
            Cookie tokenCookie = new Cookie("token", user.getToken());
            tokenCookie.setDomain("hello.community.com");
            tokenCookie.setPath("/");
            response.addCookie(tokenCookie);
        }*/

        //return "redirect:http://hello.community.com:8001/test";
        return "index";
    }

}
