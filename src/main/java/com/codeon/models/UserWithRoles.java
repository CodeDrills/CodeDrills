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

    private String userName;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities;

    public UserWithRoles(User user) {
        this.userName = user.getUsername();
        this.password = user.getPassword();
        this.active = user.isActive();
        //Will refactor once functioning and time permits
        String roles = "";
        for(int i = 0; i < user.getRoleList().size(); i++) {
            if(i != user.getRoleList().size() - 1) {
                roles += user.getRoleList().get(i).getRole() + ",";
            } else {
                roles += user.getRoleList().get(i).getRole();
            }
        }
        this.authorities = Arrays.stream(roles.split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
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
        return userName;
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
        return active;
    }

//    public UserWithRoles(User user) {
//        super(user);  // Call the copy constructor defined in User
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        String roles = ""; // Since we're not using the authorization part of the component
//        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
