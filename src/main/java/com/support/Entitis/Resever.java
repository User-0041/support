package com.support.Entitis;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;


@Entity
@AllArgsConstructor

public class Resever extends User {
    static String privilage = "Resever";
    public Resever(String Username,String password){
        super(Username,password);
    }
}