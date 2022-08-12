package com.support.ReposetryPorxy;

import com.support.Entitis.Ticket;

import com.support.Repositories.TicketRepositrie;


import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



@Service
public class TicketRepositrieProxySort {

    @Autowired 
    TicketRepositrie TicketRepositrie;


    public List<Ticket> getList(String Sort,  String Key){
    List<Ticket> Unsorted = TicketRepositrie.findByMachineIdStartingWith(Key);
    if(Sort!=null){
    if(Sort.equals("Date")){  
        Collections.sort(Unsorted,new TicketComparatorDate());
    }
    if(Sort.equals("Status")  ){
        Collections.sort(Unsorted,new TicketComparatorStatus());
    }if(Sort.equals("Level")){
        Collections.sort(Unsorted,new TicketComparatorLevel());

    }
}
    return Unsorted;



    };

}
