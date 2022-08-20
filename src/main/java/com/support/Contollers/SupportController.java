package com.support.Contollers;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
        
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.support.Entitis.Resever;
import com.support.Entitis.Ticket;
import com.support.Entitis.User;
import com.support.Enums.Status;
import com.support.Services.BreakDownService;
import com.support.Services.MachineService;
import com.support.Services.TicketService;
import com.support.Services.UserService;
import com.support.Utils.Utils;





@Controller
public class SupportController {
    //Servises Injection
    @Autowired
    TicketService TicketService;
    @Autowired 
    BreakDownService BreakDownService;
    @Autowired
    MachineService MachineService;
    @Autowired
    UserService UserService;

    @GetMapping("/Support/OpenSupport")
    public String OpenSupport(Ticket ticket,Principal principal,Model model) {
        model.addAttribute("BreakDowns",BreakDownService.FindAll() );
        model.addAttribute("username",principal.getName() );

        return "OpenSupport";
    }

    @GetMapping("/Support/CloseSupport/{id}")
    public String CloseSupportPage(@PathVariable("id") String id,Principal principal,Model model) {
        model.addAttribute("username",principal.getName() );

        model.addAttribute("Tid", id);
        return "CloseSupport";
    }


 
    @PostMapping("/Support/TakeSupport/{id}")
    public String TakeSupport(@PathVariable("id") String id,Principal principal, Model model) {
        Optional<Ticket> t= TicketService.FindById(id);
        if(t.isEmpty()){return "index";}
        t.get().setTecnesstion((Resever) UserService.findByUsername(principal.getName()));        
        t.get().setStatus(Status.InProgress);
        t.get().setTakeDate(Utils.CurrentDate());
        TicketService.CloseTicket(t.get());

        return "redirect:/Support/ListSupport";
    }



    @PostMapping("/Support/DropeSupport/{id}")
    public String DropeSupport(@PathVariable("id") String id,Principal principal, Model model) {
        Optional<Ticket> t= TicketService.FindById(id);
        if(t.isEmpty()){ return "index";}
        if((t.get().getUser().getUsername()==principal.getName())){ return "index";};
        try{
            if((t.get().getTecnesstion().getUsername()==principal.getName())){return "index";};
        }catch(Exception e) {
            TicketService.DropTicket(t.get());
        }

       
        

        return "redirect:/Support/ListSupport";
    }


 
    @PostMapping("/Support/CloseSupport")
    public String CloseSupport(@RequestParam(name = "DESCREPTION") String DESCREPTION,@RequestParam(name = "date") Date date,@RequestParam(name = "ID") String id,@RequestParam(name = "OBSERVATION") String OBSERVATION, Model model) {
       

        Optional<Ticket> t= TicketService.FindById(id);
    
        if(t.isEmpty()){ return "index";}
        
        t.get().setObservetion(OBSERVATION);
        t.get().setDescrption(DESCREPTION);
        t.get().setCloseDate(date);
        t.get().setStatus(Status.Closed);
        TicketService.CloseTicket(t.get());
        return "redirect:/Support/ListSupport";

    }

    @GetMapping("/Support/ListSupport")
    public String ListSupport(Model model,@RequestParam("sort") Optional<String> sort,@RequestParam("filter") Optional<String> status,@RequestParam("page") Optional<Integer> page,@RequestParam("sort") Optional<String> Sort ,@RequestParam(required = false)Optional<String> keyword,Principal principal) {

        
        Page<Ticket>  Tikets= TicketService.FindByFilters(sort.orElse(""),status.orElse(""),keyword.orElse(""),PageRequest.of(page.orElse(0),7));
        model.addAttribute("keyword",keyword.orElse(""));
        model.addAttribute("sort",sort.orElse(""));
        model.addAttribute("filter",status.orElse(""));
        model.addAttribute("ticketList",Tikets );
        model.addAttribute("username",principal.getName() );
        User user= UserService.findByUsername(principal.getName());
        model.addAttribute("Auth",user.getPrivilage() );
        
        
        int totalPages = Tikets.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(0, totalPages-1)
            .boxed()
            .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        

        
        return "ListSupport";
    }

    @GetMapping
    public ModelAndView Index(Principal principal,Model model){
        return new ModelAndView("redirect:/login");
    }

    @PostMapping("/Support/OpenSupport")
    String  OpenTicket( @Valid Ticket ticket,BindingResult result,Principal principal ,Errors errors, Model model){
        model.addAttribute("BreakDowns",BreakDownService.FindAll() );



        if (null != errors && errors.getErrorCount() > 0) { return "OpenSupport";}
   


        ticket.setStatus(Status.Open);
        ticket.setIssueDate(Utils.CurrentDate());
        ticket.setUser(UserService.findByUsername(principal.getName()));       
        TicketService.CloseTicket(ticket);
        return "redirect:/Support/ListSupport";

    }


    @GetMapping("/Support/MoreInfo/{id}")
    String TicketInfo(@PathVariable("id")String id,Principal principal , Model model){
        Optional<Ticket> t= TicketService.FindById(id);

      
        model.addAttribute("Duration",   Utils.Durration(t.get()));
        model.addAttribute("username",principal.getName() );

        model.addAttribute("Ticket", t.orElse(null));
        return "info";  
    }
 

    @GetMapping("Debug")
    String Debug(){
     
        return "Debug";  
    }
}
