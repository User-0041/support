package com.support.Servicesinterfaces;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.support.Entitis.Machine;
import com.support.Entitis.Ticket;
import com.support.Entitis.User;
import com.support.Enums.Level;
@Service
public interface TicketInterface {
    void CreateTicket(Ticket t);
    void DropTicket(Ticket t);
    void CloseTicket(Ticket t);
    Page<Ticket> FindAll(Pageable pageable);
    Page<Ticket> FindByMachine(Machine m,Pageable pageable);
    Page<Ticket> FindByUser(User u,Pageable pageable);
    Page<Ticket> FindByLevel(Level l,Pageable pageable);
    Page<Ticket> FindBySearch(String Key,Pageable pageable);
  
    Integer countByTecnesstionUsername(String Username);
    Integer countByUserUsername(String Username);

    Optional<Ticket> FindById(String id);




}