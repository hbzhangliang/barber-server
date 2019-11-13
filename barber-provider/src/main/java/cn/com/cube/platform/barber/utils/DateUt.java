package cn.com.cube.platform.barber.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class DateUt {

    public static Date nextDayMinute(int index) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, index);
        return calendar.getTime();
    }

    public static String formatDateToStrToDay(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public static String formatDateToDt (Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(date);
    }

    public static String nowDateFormatToStr () {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    public static String esDate () {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return sdf.format(new Date());
    }

    public static String sevenDayDt (int num) {
        List<String> days = new ArrayList<>(num);
        for ( int i = 1 ; i <= num ; i ++ ) {
            days.add(DateUt.formatDateToDt(DateUt.nextDayMinute(-1*i)));
        }return String.join(",", days);
    }

    public static void main (String args[]) {
        System.out.println( formatDateToDt(nextDayMinute(-1)) );
    }

}
