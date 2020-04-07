package com.liangliang.community.security.component;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Liangliang
 * @date 2020/4/7
 * @desc
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private String tokenHeader;
    private String tokenHead;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {

        String authHeader = request.getHeader(tokenHeader);
    }
}
