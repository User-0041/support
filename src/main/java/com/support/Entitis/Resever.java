package com.support.Entitis;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;


@Entity
@AllArgsConstructor

public class Resever extends User {
    static String privilage = "Resever";
    public Resever(String Username,String password,Integer telephoneNumber,String email , Boolean Active ){
        super(Username,password,telephoneNumber,email,Active);

    }


    public Resever(User user){
        super(user.getUsername(),user.getPassword(),user.getTelephoneNumber(),user.getEmail(),user.IsActive);
    }

    @Override
    public String getPrivilage() {
                return privilage;
    }

    @Override
    public String getUsername() {
                return super.getUsername();
    }

}
