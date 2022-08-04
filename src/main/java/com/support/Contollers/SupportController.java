package com.support.Contollers;

import java.security.Principal;
import java.util.Optional;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.support.Entitis.Ticket;
import com.support.Entitis.User;

import com.support.Enums.Status;
import com.support.Services.BreakDownService;
import com.support.Services.MachineService;
import com.support.Services.TicketService;
import com.support.Utils.Utils;
import com.support.security.SupportUserDetails;




@Controller
public class SupportController {
    //Servises Injection
    @Autowired
    TicketService TicketService;
    @Autowired 
    BreakDownService BreakDownService;
    @Autowired
    MachineService MachineService;

    @GetMapping("/Support/OpenSupport")
    public String OpenSupport(Ticket ticket,Model model) {
        model.addAttribute("BreakDowns",BreakDownService.FindAll() );
        return "OpenSupport";
    }

    @GetMapping("/Support/CloseSupport")
    public String CloseSupportPage(Model model) {
    
        return "CloseSupport";
    }

    @PostMapping("/Support/CloseSupport/{id}")
    public String CloseSupport(@PathVariable("id") String id,@RequestParam(name = "DESCREPTION") String DESCREPTION ,@RequestParam(name = "OBSERVATION") String OBSERVATION, Model model) {
        id="32d743a6-29a6-4364-9fd8-f224aee3df5a";
        Optional<Ticket> t= TicketService.FindById(id);
        if(t.isEmpty()){return "index";}
        
        t.get().setObservetion(OBSERVATION);
        t.get().setDescrption(DESCREPTION);
        t.get().setCloseDate(Utils.CurrentDate());
        t.get().setStatus(Status.Closed);
        TicketService.CloseTicket(t.get());
        return "redirect:/";
    }

    @GetMapping("/Support/ListSupport")
    public String ListSupport(Model model) {
        model.addAttribute("ticketList",TicketService.FindAll(PageRequest.of(0,7)) );
        
        return "ListSupport";
    }

    @GetMapping
    public String Index(Principal principal,Model model){
        return "Index";
    }

    @PostMapping("/Support/OpenSupport")
    String  OpenTicket( @Valid Ticket ticket, Errors errors, Model model,BindingResult result){
        model.addAttribute("BreakDowns",BreakDownService.FindAll() );
        if (null != errors && errors.getErrorCount() > 0) { return "OpenSupport";}
        System.out.println(errors);
        ticket.setStatus(Status.Open);
        ticket.setIssueDate(Utils.CurrentDate());
        ticket.setUser(new User("U1", "U1"));       
        TicketService.CloseTicket(ticket);
        return "index";
    }
}
