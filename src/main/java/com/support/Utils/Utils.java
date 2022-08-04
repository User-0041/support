package com.support.Utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Utils{
     public static Date CurrentDate() {
        return Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
        
    }
}