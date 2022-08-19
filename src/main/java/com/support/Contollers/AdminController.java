package com.support.Contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
@GetMapping(value="/Admin/Users")
public String Users() {
    return "Debug";
}

@GetMapping(value="/Admin/AddUsers")
public String AddUsers() {
    return "Debug";
}


@PostMapping(value="/Admin/SaveUsers")
public String SaveUser() {
    return null;
}




}
