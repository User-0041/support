package com.support.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.support.Entitis.User;
import com.support.Repositories.UserRepositorie;
import com.support.Servicesinterfaces.UserInterface;
@Service
public class UserService implements UserInterface {
    @Autowired
    UserRepositorie UserRepositorie;

    @Override
    public void CreateResever(User r) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void RevokeResever(User r) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void findAll() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public User findByUsername(String Username) {
        return UserRepositorie.findByUsername(Username);
    }
     
}
