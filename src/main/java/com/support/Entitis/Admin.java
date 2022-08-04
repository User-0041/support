package com.support.Entitis;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
public class Admin extends User {
    static String privilage = "Admin";
    
}
