package com.codeon.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserWithRoles extends User implements UserDetails {
    private String roles;
    private boolean isActive;
    public UserWithRoles(User user) {
        super(user);
        String roles = "";
        for(int i = 0; i < user.getRoleList().size(); i++) {
            if(i != user.getRoleList().size() - 1) {
                roles += "ROLE_" + user.getRoleList().get(i).getRole() + ",";
            } else {
                roles += "ROLE_" + user.getRoleList().get(i).getRole();
            }
        }
        this.roles = roles;
        this.isActive = user.isActive();
         // Call the copy constructor defined in User
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.commaSeparatedStringToAuthorityList(this.roles);
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
        return isActive;
    }
}
