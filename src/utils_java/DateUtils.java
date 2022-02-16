/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils_java;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author amiya
 */
public class DateUtils {
    public static SimpleDateFormat sdf_ymdhms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public static Date addDays(Date tdate, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(tdate);
        c.add(Calendar.DATE, days);

        return c.getTime();
    }

    public static Date addMinutes(Date tdate, int mins) {
        Calendar c = Calendar.getInstance();
        c.setTime(tdate);
        c.add(Calendar.MINUTE, mins);

        return c.getTime();
    }

    public static long timeDiff(Date tdate1, Date tdate2) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(tdate1);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(tdate2);

        long tdiff = c1.getTimeInMillis() - c2.getTimeInMillis();

        return tdiff;
    }
}
