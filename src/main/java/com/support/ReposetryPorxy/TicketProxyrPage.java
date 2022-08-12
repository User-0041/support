package com.support.ReposetryPorxy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.support.Entitis.Ticket;
import com.support.Enums.Status;



@Service
public class TicketProxyrPage {
    @Autowired
    TicketRepositrieProxyFilter TicketRepositrieProxyFilter;

    public Page<Ticket> getList(String Sort , String status , String Key,Pageable pageable){
        List<Ticket> List = TicketRepositrieProxyFilter.getList(Sort, status, Key);
         int start = (int)pageable.getOffset();
         int end = Math.min((start + pageable.getPageSize()), List.size());
         Page<Ticket> page = new PageImpl<>(List.subList(start, end), pageable, List.size());
         return page;


        
    }
}
