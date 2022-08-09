package com.support.ReposetryPorxy;

import java.util.Comparator;

import com.support.Entitis.Ticket;

  public final class  TicketComparatorDate implements Comparator<Ticket>  {

    @Override
    public int compare(Ticket arg0, Ticket arg1) {
        return (int) (arg1.getIssueDate().getTime()-arg0.getIssueDate().getTime());
    }



}