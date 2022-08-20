package com.support.Servicesinterfaces;

import java.util.List;

import com.support.Entitis.User;

public interface UserInterface  {
    void CreateUser(User r);
    void RevokeResever(String r);
    List<User> findAll();
    User findByUsername(String Username );
}
