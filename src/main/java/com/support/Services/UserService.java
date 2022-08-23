package com.support.Services;

import java.util.List;

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
    public void CreateUser(User r) {
        UserRepositorie.save(r);
        
    }

    @Override
    public void RevokeResever(String username) {

        User u = UserRepositorie.findByUsername(username);
        u.setIsActive(!u.getIsActive());
        UserRepositorie.save(u);
    }

    @Override
    public List<User> findAll() {

        return UserRepositorie.findAll();

        
    }

    @Override
    public User findByUsername(String Username) {
        return UserRepositorie.findByUsername(Username);
    }

    @Override
    public Integer CountIssued(String name) {
      return  UserRepositorie.CountIssued(name);
    }

    @Override
    public Integer CountReseloved(String name) {
       return  UserRepositorie.CountIssued(name);
       
    }
     
}
