package com.example.pat.hack2015;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by ANTHONY on 11/8/2015.
 */
public class TimeStamp {

public static String getTimeStamp(){
    Calendar c = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String strDate = sdf.format(c.getTime());
        return strDate;
}
}
