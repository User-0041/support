package com.support.Contollers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.support.security.SecurityConfiguration;

import com.support.Entitis.Resever;
import com.support.Entitis.User;
import com.support.Services.UserService;
import com.support.Services.UserWraper;
import com.support.Utils.Utils;

@Controller
public class AdminController {

    
@Autowired
UserService UserService;


@Autowired
private PasswordEncoder PasswordEncoder;


@GetMapping(value="/Admin/Users")
public String Users(Model model/* ,Principal principal*/) {
    //model.addAttribute("username",principal.getName() );
    List<User> u= UserService.findAll();
    List<UserWraper> uw = Utils.WrapUserList(u);
    model.addAttribute("Users",uw);
    return "UsersList";
}

@PostMapping(value="/Admin/DropeUser/{id}")
public String DropeUser(@PathVariable("id") String id) {
    UserService.RevokeResever(id);
   return "Debug";
}

@GetMapping(value="/Admin/AddUser")
public String AddUsers(User user) {
    return "AddUser";
}


@PostMapping(value="/Admin/SaveUsers")
public String SaveUser(@Valid User user,BindingResult result,Errors errors, @RequestParam(value = "Role") String role) {
    if (null != errors && errors.getErrorCount() > 0) { return "AddUser";}

    System.out.println(user.getTelephoneNumber());
    user.setPassword( PasswordEncoder.encode(user.getTelephoneNumber().toString()) );
    System.out.println(role);
    if(role.equals("Resever")){
       UserService.CreateUser(new Resever(user));
        System.out.println("Resever");
    }else{
        UserService.CreateUser(user);
      System.out.println("User");

    }
    return "Debug";
}




}
