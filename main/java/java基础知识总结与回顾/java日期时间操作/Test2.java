package java基础知识总结与回顾.java日期时间操作;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class Test2 {
    public static void main(String[] args) {
        //获取localDatetime对象  生成当前时间
        LocalDateTime local = LocalDateTime.now();
        System.out.println(local);  //2019-11-05T11:11:50.430

        System.out.println("两天之后的时间是："+local.plusDays(2));//2019-11-07T11:15:42.215
        System.out.println("两个小时之后的时间是："+local.plusHours(2));//2019-11-05T13:15:42.215
        System.out.println("两个分钟之后的时间是："+local.plusMinutes(2));//2019-11-05T11:17:42.215
        System.out.println("30秒之后的时间是："+local.plusSeconds(30));//2019-11-05T11:16:12.215


        //localDateTime ->localDate
        LocalDate date = local.toLocalDate();

        //localDateTime -> String
        String str = local.toString();

        System.out.println("两天之前的时间是："+local.minusDays(2));//2019-11-05T11:16:12.215
        System.out.println("两小时之前的时间是："+local.minusHours(2));//2019-11-05T09:24:04.409
        System.out.println("两分钟之前的时间是："+local.minusMinutes(2));//2019-11-05T11:22:04.409
        System.out.println("30秒之前的时间是："+local.minusSeconds(30));//2019-11-05T11:23:34.409

        //获取年份
        int year = local.getYear();
        //获取月份
        Month month = local.getMonth();
        //获取分钟
        int minute = local.getMinute();
        //获取星期几
        DayOfWeek week = local.getDayOfWeek(); // TUSDAY
        System.out.println(week);




    }
}
