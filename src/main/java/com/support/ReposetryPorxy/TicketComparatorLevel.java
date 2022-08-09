package com.support.ReposetryPorxy;

import java.util.Comparator;

import com.support.Entitis.Ticket;

  public final class  TicketComparatorLevel implements Comparator<Ticket>  {

    @Override
    public int compare(Ticket arg0, Ticket arg1) {
        return (int) (arg1.getLevel().compareTo(arg0.getLevel()));
    }



}