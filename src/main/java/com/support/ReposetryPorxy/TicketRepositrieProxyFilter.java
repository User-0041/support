package com.support.ReposetryPorxy;

import com.support.Entitis.Ticket;
import com.support.Enums.Status;
import com.support.Repositories.TicketRepositrie;

import net.bytebuddy.TypeCache.Sort;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TicketRepositrieProxyFilter {

    @Autowired 
    TicketRepositrieProxySort  TicketRepositrieProxySort ;
    public List<Ticket> getList(String Sort , String status , String Key){
    List<Ticket> Unfilterd = TicketRepositrieProxySort.getList(Sort,  Key);
    List<Ticket> filterd  =new  ArrayList<>() ;
   try{
    if(Status.valueOf(status)!=null){
        for(Ticket t  : Unfilterd){
         if(t.getStatus().equals(Status.valueOf(status))){
             filterd.add(t);
         }
        }
        return filterd;
     };


   }catch(Exception e){
    System.err.println(e);
   }
    
    return Unfilterd;
    }
}
