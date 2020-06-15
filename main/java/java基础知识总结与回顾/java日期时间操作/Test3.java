package java基础知识总结与回顾.java日期时间操作;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test3 {
    public static void main(String[] args) throws ParseException {
        getDays();
    }


    //和婷婷认识的时间
    public static void getDays() throws ParseException {
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
        String begin = "2020-01-20";
        Date biginDate = simple.parse(begin);
        Date date = new Date();
        int knowShe = (int) (date.getTime()-biginDate.getTime())/(1000*60*60*24)+1;
        System.out.println(knowShe);
    }
}
