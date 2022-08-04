package com.support.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.support.Entitis.User;
import com.support.Services.UserService;

import net.bytebuddy.asm.Advice.Return;
@Service
public class UserDetailsServiceImp implements UserDetailsService {
    @Autowired
    UserService UserService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = UserService.findByUsername(username);
        if (user==null){throw new UsernameNotFoundException("User Not found");};
        return new SupportUserDetails(user);
    }
     
}
