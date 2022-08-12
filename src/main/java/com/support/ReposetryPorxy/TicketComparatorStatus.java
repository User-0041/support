package com.support.ReposetryPorxy;

import java.util.Comparator;

import com.support.Entitis.Ticket;

public final class TicketComparatorStatus implements Comparator<Ticket>  {

    @Override
    public int compare(Ticket arg0, Ticket arg1) {
      return arg1.getStatus().compareTo(arg0.getStatus());
    }
    
}
