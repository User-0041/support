package com.support.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.support.Entitis.User;
@Repository 
public interface UserRepositorie extends JpaRepository< User,String> {
    
}
