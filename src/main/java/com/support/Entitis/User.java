package com.support.Entitis;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder.Default;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {
    @Id
    @NotBlank
    String username;
    String password;
   //TODO::FIX THIS
    Integer telephoneNumber;
    @NotBlank
    String email;
    Boolean IsActive=true;  
    static String privilage = "User";
    public  String getPrivilage() {
        return privilage;
    }
}
