package com.liangliang.community.bo;

import com.liangliang.community.model.CAdmin;
import com.liangliang.community.model.CResource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Liangliang
 * @date 2020/4/10
 * @desc
 */
public class AdminUserDetails implements UserDetails {
    private CAdmin cAdmin;
    private List<CResource> resourceList;

    public AdminUserDetails(CAdmin cAdmin, List<CResource> resourceList) {
        this.cAdmin = cAdmin;
        this.resourceList = resourceList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 返回当前用户的角色
        return resourceList.stream()
                .map(role -> new SimpleGrantedAuthority(role.getId() + ":" + role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return cAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return cAdmin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return cAdmin.getStatus().equals(1);
    }
}
