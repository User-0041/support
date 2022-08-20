package com.support.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;


import com.support.Entitis.User;


@Configurable
public class UserWraper {
    @Autowired
	TicketService TicketService;

    
    User user;
    public UserWraper(User user){
        this.user=user;
        
    }

    public String getEmail(){
    
        return user.getEmail();
        
    }

    public String getPassword(){
        return user.getPassword();
    }

    public String getPrivilage(){
        return user.getPrivilage();
    }
   

    
    public Integer getTelephoneNumber(){
        return user.getTelephoneNumber();
    }
   

    public String getUsername(){
        return user.getUsername();
    }

    public Boolean IsActive(){
        return user.getIsActive();
    }
    //TODO::FIX THIS BS TOMMORW
    public Integer getIssued(){
        return 5;
       // return TicketService.countByTecnesstionUsername(this.getUsername());

    }

    public Integer getInprogress(){
        return 5;
        //return TicketService.countByTecnesstionUsername(this.getUsername());
    }
}
