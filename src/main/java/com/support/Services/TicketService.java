package com.support.Services;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.support.Entitis.Machine;
import com.support.Entitis.Ticket;
import com.support.Entitis.User;
import com.support.Enums.Level;
import com.support.Enums.Status;
import com.support.ReposetryPorxy.TicketProxyrPage;
import com.support.Repositories.TicketRepositrie;
import com.support.Servicesinterfaces.TicketInterface;



@Service
public class TicketService implements TicketInterface{
    @Autowired
    TicketRepositrie TicketRepositrie;
    @Autowired
    TicketProxyrPage TicketProxyrPage;


    @Override
    public void CreateTicket(Ticket t) {
       TicketRepositrie.save(t);
        
    }

    @Override
    public void DropTicket(Ticket t) {
        TicketRepositrie.delete(t);
        
    }

    @Override
    public void CloseTicket(Ticket t) {
    
        TicketRepositrie.save(t);
        
    }

    @Override
    public Page<Ticket> FindAll(Pageable pageable) {
        return TicketRepositrie.findAll(pageable);
    }

    @Override
    public Page<Ticket> FindByMachine(Machine m,Pageable pageable) {
        return TicketRepositrie.findByMachine(m, pageable);
    }

    @Override
    public Page<Ticket> FindByUser(User u,Pageable pageable) {
        return TicketRepositrie.findByUser(u, pageable); 
    }

    @Override
    public Page<Ticket> FindByLevel(Level l, Pageable pageable) {
        
        return TicketRepositrie.findByLevel(l, pageable);
    }

    @Override
    public Optional<Ticket> FindById(String id) {
        
        return TicketRepositrie.findById(id);
    }

    @Override
    public Page<Ticket> FindBySearch(String key, Pageable pageable ) {
        return TicketRepositrie.findByMachineIdStartingWith(key, pageable);
    }
    
    public Page<Ticket> FindByFilters(String Sort , String status , String Key,Pageable pageable){
        System.out.println(Sort);
    return TicketProxyrPage.getList(Sort, status, Key, pageable);
 
    }
 

}