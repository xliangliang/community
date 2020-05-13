package com.liangliang.community.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.liangliang.community.bo.AdminUserDetails;
import com.liangliang.community.dao.AdminDao;
import com.liangliang.community.dao.AdminRoleRelationDao;
import com.liangliang.community.dao.FollowerFansRelationDao;
import com.liangliang.community.dto.AdminDetailInfoDto;
import com.liangliang.community.dto.AdminParam;
import com.liangliang.community.mapper.CAdminLoginLogMapper;
import com.liangliang.community.mapper.CAdminMapper;
import com.liangliang.community.model.CAdmin;
import com.liangliang.community.model.CAdminExample;
import com.liangliang.community.model.CAdminLoginLog;
import com.liangliang.community.model.CResource;
import com.liangliang.community.security.utils.JwtTokenUtil;
import com.liangliang.community.service.AdminCacheService;
import com.liangliang.community.service.AdminService;
import com.liangliang.community.utils.GetIpAddressUtils;
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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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
    private CAdminLoginLogMapper loginLogMapper;
    @Autowired
    private AdminRoleRelationDao adminRoleRelationDao;
    @Autowired
    private FollowerFansRelationDao followerFansRelationDao;
    @Autowired
    private AdminCacheService adminCacheService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public CAdmin register(AdminParam adminParam) {
        CAdmin admin = new CAdmin();
        BeanUtil.copyProperties(adminParam, admin);
        admin.setCreateTime(new Date());
        admin.setStatus(1);
        CAdminExample example = new CAdminExample();
        example.createCriteria().andUsernameEqualTo(admin.getUsername());
        List<CAdmin> admins = adminMapper.selectByExample(example);
        if (admins.size() > 0) {
            return null;
        }
        // 加密
        String password = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(password);
        adminMapper.insert(admin);
        return admin;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
            insertLoginLog(username);
        } catch (AuthenticationException e) {
            logger.warn("登录异常：{}", e.getMessage());
        }
        return token;
    }

    /**
     * 添加登录日志
     *
     * @param username
     */
    private void insertLoginLog(String username) {
        CAdmin admin = getAdminByUsername(username);
        if (admin == null)
            return;
        CAdminLoginLog loginLog = new CAdminLoginLog();
        loginLog.setAdminId(admin.getId());
        loginLog.setCreateTime(new Date());
        // 获取ServletHttpRequest
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        loginLog.setIp(GetIpAddressUtils.getIpAddress(request));
        loginLogMapper.insert(loginLog);
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
    public AdminDetailInfoDto getAdminDetailInfo(String username) {
        CAdmin admin = getAdminByUsername(username);
        return followerFansRelationDao.selectAdminDetailInfo(admin.getId());
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

    @Override
    public String refreshToken(String token) {
        return jwtTokenUtil.refreshHeadToken(token);
    }

}
