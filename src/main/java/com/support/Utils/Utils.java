package com.support.Utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.support.Entitis.Ticket;

public class Utils{
     public static Date CurrentDate() {
        return Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static String Durration(Ticket t){
        long TimeH = t.getCloseDate().getTime() - t.getIssueDate().getTime()  ;
        String Houres = String.valueOf(TimeUnit.HOURS.convert(TimeH,TimeUnit.MILLISECONDS)) ;
        String Minits = String.valueOf(TimeUnit.MINUTES.convert(TimeH,TimeUnit.MILLISECONDS)%60) ;


        return   Houres +":" + Minits;
    }
}