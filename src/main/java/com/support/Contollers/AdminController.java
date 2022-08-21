package com.support.Contollers;

import java.io.IOException;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
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
import com.support.Entitis.Machine;
import com.support.Entitis.MachineFamily;
import com.support.Entitis.Resever;
import com.support.Entitis.Ticket;
import com.support.Entitis.User;
import com.support.Services.MachineFamilyService;
import com.support.Services.MachineService;
import com.support.Services.TicketService;
import com.support.Services.UserService;
import com.support.Services.UserWraper;
import com.support.Utils.ExcelGenerator;
import com.support.Utils.Utils;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class AdminController {

@Autowired
MachineService MachineService;    

@Autowired
UserService UserService;

@Autowired
MachineFamilyService MachineFamilyService;

@Autowired
private PasswordEncoder PasswordEncoder;


@Autowired
private TicketService TicketService;

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



@PostMapping(value="/Admin/SaveUsers")
public String SaveUser(@Valid User user,BindingResult result,Errors errors, @RequestParam(value = "Role") String role) {
    if (null != errors && errors.getErrorCount() > 0) { return "AddUser";}


    user.setPassword( PasswordEncoder.encode(user.getTelephoneNumber().toString()) );

    if(role.equals("Resever")){
       UserService.CreateUser(new Resever(user));
      
    }else{
        UserService.CreateUser(user);
    }
    return "Debug";
}



@GetMapping(value="/Admin/Machines")
public String Machines(Model model){
    model.addAttribute("Machines",MachineService.FindAll());
    return "MachinesList";
}


@GetMapping(value="/Admin/AddMachine")
public String Machines(Machine machine,Model model){
  
    model.addAttribute("MachineFamillys", MachineFamilyService.findAll());
    return "AddMachine";
}


@PostMapping(value="/Admin/AddMachine")
public String AddMachine(@Valid Machine machine,BindingResult result,Errors errors,Model model) {

    Boolean Unique=false;
    model.addAttribute("MachineFamillys", MachineFamilyService.findAll());

    if(MachineService.FindMachine(machine).isPresent()){
        Unique=true;
        model.addAttribute("Unique", Unique);
        return "AddMachine";
    }

    if (null != errors && errors.getErrorCount() > 0 ) {   return "AddMachine";}
    MachineService.CreateMachine(machine);
    return "Debug"; 
}




@GetMapping(value="/Admin/AddMachineFamilly")
public String AddMachineFamilly(MachineFamily family) {
    return "AddMachineFamilly" ;
}


@PostMapping(value="/Admin/AddMachineFamilly")
public String postMethodName(@Valid MachineFamily family,BindingResult result,Errors errors,Model model) {
    Boolean Unique = false;
    if(MachineFamilyService.findByid(family.getId()).isPresent()){
        Unique=true;
        model.addAttribute("Unique", Unique);
        return "AddMachineFamilly";
    }
    if (null != errors && errors.getErrorCount() > 0 ) {   model.addAttribute("Unique", Unique);return "AddMachineFamilly";}
      MachineFamilyService.CreateMachineFamily(family); 
    return "Debug";
}


@GetMapping("/XL")
public void exportIntoExcelFile(HttpServletResponse response) throws IOException {
    response.setContentType("application/octet-stream");
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
    String currentDateTime = dateFormatter.format(new Date());

    String headerKey = "Content-Disposition";
    String headerValue = "attachment; filename=student" + currentDateTime + ".xlsx";
    response.setHeader(headerKey, headerValue);

    List < Ticket > listOfStudents = TicketService.FindAllList();

    ExcelGenerator generator = new ExcelGenerator(listOfStudents);

    generator.generateExcelFile(response);
}


}


