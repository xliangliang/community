package com.liangliang.community.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.liangliang.community.annotation.TestAnnotation;
import com.liangliang.community.bo.AdminUserDetails;
import com.liangliang.community.dao.AdminDao;
import com.liangliang.community.dao.AdminRoleRelationDao;
import com.liangliang.community.dto.RegisterParam;
import com.liangliang.community.mapper.CAdminMapper;
import com.liangliang.community.model.CAdmin;
import com.liangliang.community.model.CAdminExample;
import com.liangliang.community.model.CResource;
import com.liangliang.community.security.utils.JwtTokenUtil;
import com.liangliang.community.service.AdminCacheService;
import com.liangliang.community.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Liangliang
 * @date 2020/4/2
 * @desc
 */
@Service
public class AdminServiceImpl implements AdminService {

    private final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    private CAdminMapper adminMapper;
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private AdminRoleRelationDao adminRoleRelationDao;
    @Autowired
    private AdminCacheService adminCacheService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public int register(RegisterParam registerParam) {
        CAdmin user = adminDao.select(registerParam.getUsername());
        if (user != null) {
            return -1;
        }
        return adminDao.insert(registerParam);
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = loadUserByUsername(username);
            logger.info("password: {}",password);
            logger.info("user Details password: {}",userDetails.getPassword());
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            logger.warn("登录异常：{}", e.getMessage());
        }
        return token;
    }

    @TestAnnotation
    @Override
    public void testAspect() {
        System.out.println("TestAspect");
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        CAdmin admin = getAdminByUsername(username);
        if (admin != null) {
            List<CResource> resourceList = getResourceList(admin.getId());
            return new AdminUserDetails(admin, resourceList);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    @Override
    public CAdmin getAdminByUsername(String username) {
        CAdmin admin = adminCacheService.getAdmin(username);
        if (admin != null)
            return admin;
        CAdminExample example = new CAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<CAdmin> adminList = adminMapper.selectByExample(example);
        if (adminList != null && adminList.size() > 0) {
            admin = adminList.get(0);
            adminCacheService.setAdmin(admin);
        }
        return admin;
    }

    @Override
    public List<CResource> getResourceList(Long adminId) {
        List<CResource> resourceList = adminCacheService.getResourceList(adminId);
        if (resourceList != null)
            return resourceList;
        resourceList = adminRoleRelationDao.getResourceList(adminId);
        if (CollUtil.isNotEmpty(resourceList)) {
            adminCacheService.setResourceList(adminId, resourceList);
        }
        return resourceList;
    }

}
