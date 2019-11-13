package cn.com.cube.platform.barber.utils;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilHelper {

    private final static char UNDERLINE='_';


    /**
     * 将驼峰转为下横线
     * 比如createBy  ---> create_by
     * @param param
     * @return
     */
    public static String camelToUnderline(String param){
        if (param==null||"".equals(param.trim())){
            return "";
        }
        int len=param.length();
        StringBuilder sb=new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c=param.charAt(i);
            if (Character.isUpperCase(c)){
                sb.append(UNDERLINE);
                sb.append(Character.toLowerCase(c));
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private  static SimpleDateFormat sdfYMD = new SimpleDateFormat("yyyy-MM-dd");

    public static Date parseDateYMD(String str)throws ParseException {
        return sdfYMD.parse(str);
    }


    private  static SimpleDateFormat sdfyyyyMMdd = new SimpleDateFormat("yyyyMMdd");

    private  static SimpleDateFormat sdfyyyyMMddHHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String parseDateyyyyMMdd(Date dt){
        try {
            return sdfyyyyMMdd.format(dt);
        }
        catch (Exception e){
            return null;
        }
    }

    public static String parseTimeDetail(Long timestamp){
        try {
            return sdfyyyyMMddHHmmss.format(new Date(timestamp));
        }
        catch (Exception e){
            return null;
        }
    }


    public static TimeUnit getTimeUtil(String type){
        if(StringUtils.isEmpty(type)) return TimeUnit.SECONDS;
        TimeUnit result=null;
        switch (type){
            case "S":result =TimeUnit.SECONDS;break;
            case "M":result =TimeUnit.MINUTES;break;
            case "H":result=TimeUnit.HOURS;break;
            case "D":result=TimeUnit.DAYS;break;
            default:result=TimeUnit.SECONDS;
        }
        return result;
    }


    /**
     * 对象转map
     * @param obj
     * @return
     * @throws Exception
     */
    public static HashMap<String, Object> convertToMap(Object obj){
        try {
            HashMap<String, Object> map = new HashMap<String, Object>();
            Field[] fields = obj.getClass().getDeclaredFields();
            for (int i = 0, len = fields.length; i < len; i++) {
                String varName = fields[i].getName();
                boolean accessFlag = fields[i].isAccessible();
                fields[i].setAccessible(true);

                Object o = fields[i].get(obj);
                if (o != null)
                    map.put(varName, o.toString());

                fields[i].setAccessible(accessFlag);
            }

            return map;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public static String getMondayOfNWeek( int num) {
        Calendar c = Calendar.getInstance();
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0)
            day_of_week = 7;
        c.add(Calendar.DATE, -day_of_week + 1+7*num);
        return parseDateyyyyMMdd(c.getTime());
    }

    public static String getSundayOfNWeek(int num) {
        Calendar c = Calendar.getInstance();
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0)
            day_of_week = 7;
        c.add(Calendar.DATE, -day_of_week + 7+7*num);
        return parseDateyyyyMMdd(c.getTime());
    }


    public static String getFirstDayOfNMonth(int num){
        Calendar c=Calendar.getInstance();
//        int date_of_month=c.get(Calendar.DAY_OF_MONTH);
//        c.add(Calendar.DATE,-date_of_month+1);
        c.add(Calendar.MONTH,num);
        c.set(Calendar.DATE,1);
        return parseDateyyyyMMdd(c.getTime());
    }

    public static String getLastDayOfNMonth(int num){
        Calendar c=Calendar.getInstance();
        c.add(Calendar.MONTH,num+1);
        c.set(Calendar.DATE,1);
        c.add(Calendar.DATE,-1);
        return parseDateyyyyMMdd(c.getTime());
    }


    private  static List<Calendar> getClList(){
        List<Calendar> list=new ArrayList<>(4);
        Calendar clr1=Calendar.getInstance();
        clr1.set(Calendar.MONTH,0);
        clr1.set(Calendar.DATE,1);
        list.add(clr1);
        Calendar clr2=Calendar.getInstance();
        clr2.set(Calendar.MONTH,3);
        clr2.set(Calendar.DATE,1);
        list.add(clr2);
        Calendar clr3=Calendar.getInstance();
        clr3.set(Calendar.MONTH,6);
        clr3.set(Calendar.DATE,1);
        list.add(clr3);
        Calendar clr4=Calendar.getInstance();
        clr4.set(Calendar.MONTH,9);
        clr4.set(Calendar.DATE,1);
        list.add(clr4);
        return list;
    }

    public static Map<String,Object> computerQuarter(int num){
        List<Calendar> list=getClList();
        Calendar calendar=Calendar.getInstance();
        if(calendar.compareTo(list.get(0))>=0&&calendar.compareTo(list.get(1))<0){
            return computerMp(0,num);
        }
        else if(calendar.compareTo(list.get(1))>=0&&calendar.compareTo(list.get(2))<0){
            return computerMp(1,num);
        }
        else if(calendar.compareTo(list.get(2))>=0&&calendar.compareTo(list.get(3))<0){
            return computerMp(2,num);
        }
        else {
            return computerMp(3,num);
        }
    }

    //0 1 2 3
    private static Map<String,Object> computerMp(int type,int num){
        Map<String,Object> result=new HashMap<>(2);
        int yy=num/4;
        int mm=num%4;
        if(type+mm<0){
            yy-=1;
            type+=mm+4;
        }
        else if(type+mm>=4){
            yy+=1;
            type+=mm-4;
        }
        else {
            type+=mm;
        }
        Calendar startCal=Calendar.getInstance();
        startCal.add(Calendar.YEAR,yy);
        Calendar endCal=Calendar.getInstance();
        endCal.add(Calendar.YEAR,yy);

        startCal.set(Calendar.MONTH,type*3);
        startCal.set(Calendar.DATE,1);
        if(type*3+3==12){
            endCal.add(Calendar.YEAR,1);
            endCal.set(Calendar.MONTH,0);
            endCal.set(Calendar.DATE,1);
            endCal.add(Calendar.DATE,-1);
        }
        else {
            endCal.set(Calendar.MONTH, type * 3 + 3);
            endCal.set(Calendar.DATE, 1);
            endCal.add(Calendar.DATE, -1);
        }
        result.put("bt_dt0",parseDateyyyyMMdd(startCal.getTime()));
        result.put("bt_dt1",parseDateyyyyMMdd(endCal.getTime()));
        return result;
    }


    /**
     * 转为千分位
     * @param d
     * @return
     */
    public static String fmtMicrometer(Double d){
        if(d==null){
            return null;
        }
        String text=d.toString();
        DecimalFormat df = new DecimalFormat("###,##0");
        double number = 0.0;
        try {
            number = Double.parseDouble(text);
        } catch (Exception e) {
            number = 0.0;
        }
        return df.format(number);
    }


    /**
     * 转成百分数 并且保留两位小数
     * @param d
     * @return
     */
    public static String fmtPercent(Double d){
        if(d==null){
            return null;
        }
        percentDf.setMinimumFractionDigits(2);
        return percentDf.format(d);
    }


    /**
     * 转为小数
     * @param d
     * @return
     */
    public static String fmtPointNum(Double d){
        if(d==null){
            return null;
        }
        return pointDf.format(d);
    }





    public static void main(String[] args){
        Double d=112.2511562581;
        System.out.println(fmtPointNum(d));
    }


    public static String cleanEmp(String str) {
        String destination = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            destination = m.replaceAll("");
        }
        return destination;
    }



    public static int getIntValueFromStr(String str){
        return Integer.valueOf(str.replaceAll("[^0-9]", ""));
    }



    private static NumberFormat percentDf = NumberFormat.getPercentInstance();

   private static DecimalFormat pointDf = new DecimalFormat("#.00");
}
