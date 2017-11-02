package com.eztcn.user.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
public class CustomUserDetails implements UserDetails {
    private Long userid;
    private String username;
    private String password;
    private boolean enabled = true;
    private Long tid; //租户id
    private Integer rid; //角色id
    private Integer isAdmin;
    private Integer type;//用户类型
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(Long userid, String username, String password) {
        this.userid = userid;
        this.username = username;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return username;
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
        return enabled;
    }

    @Override
    public String toString() {
        return "MyUserDetails [userid=" + userid + ", username=" + username
                + ", password=" + password + ", enabled=" + enabled
                + ", authorities=" + authorities + "]";
    }
}
