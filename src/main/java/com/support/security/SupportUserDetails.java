package com.support.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.support.Entitis.User;

public class SupportUserDetails  implements UserDetails {
    private User User;

    

    public SupportUserDetails(User User){
        super();
        this.User= User;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println(User.getPrivilage());
        return Collections.singleton(new SimpleGrantedAuthority(User.getPrivilage()));

    }

    @Override
    public String getPassword() {
        
        return User.getPassword();
    }

    @Override
    public String getUsername() {
        
        return User.getUsername();
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
  
        return true;
    }
    
}
