package com.support.Entitis;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@NoArgsConstructor
public class Admin extends User {
    static String privilage = "Admin";
    @Override
    public String getPrivilage() {
        return privilage;
    }

    public Admin(String Username,String password){
        super(Username,password);
    }
    
}
