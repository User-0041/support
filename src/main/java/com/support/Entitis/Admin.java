package com.support.Entitis;

import javax.persistence.Entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@NoArgsConstructor
public class Admin extends Resever {
    static String privilage = "Admin";
    @Override
    public String getPrivilage() {
        return privilage;
    }

    public Admin(String Username,String password,String telephoneNumber,String email,Boolean Active){
        super(Username,password,telephoneNumber,email,Active);

    }

}
