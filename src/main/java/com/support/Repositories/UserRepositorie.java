package com.support.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.support.Entitis.User;
@Repository 
public interface UserRepositorie extends JpaRepository< User,String> {


    User findByUsername(String Username);
    @Query("SELECT Count(*) FROM Ticket t WHERE t.user.username = ?1")
    Integer CountIssued( String name);

    @Query("SELECT Count(*) FROM Ticket t WHERE t.tecnesstion.username = ?1  AND t.status = com.support.Enums.Status.Closed ")
    Integer CountReseloved( String name);
}
