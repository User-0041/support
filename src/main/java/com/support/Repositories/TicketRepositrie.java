package com.support.Repositories;



import java.util.List;
import java.util.Optional;




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.support.Entitis.Machine;
import com.support.Entitis.Ticket;
import com.support.Entitis.User;
import com.support.Enums.Level;

@Repository 
public interface TicketRepositrie extends JpaRepository<Ticket , String>, JpaSpecificationExecutor<Ticket> {
    Page<Ticket> findAll(Pageable pageable);
    Page<Ticket> findByMachine(Machine m,Pageable pageable);
    Page<Ticket> findByUser(User u,Pageable pageable);
    Page<Ticket> findByLevel(Level l,Pageable pageable);
    Optional <Ticket> findById(String id);
    Page<Ticket> findByMachineIdStartingWith(String key,Pageable pageable);
    List<Ticket> findByMachineIdStartingWith(String key);
   

}
