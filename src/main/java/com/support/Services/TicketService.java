package com.support.Services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.support.Entitis.Machine;
import com.support.Entitis.Ticket;
import com.support.Entitis.User;
import com.support.Enums.Level;
import com.support.Repositories.TicketRepositrie;
import com.support.Servicesinterfaces.TicketInterface;



@Service
public class TicketService implements TicketInterface{
    @Autowired
    TicketRepositrie TicketRepositrie;


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

}