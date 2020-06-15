package java基础知识总结与回顾.java日期时间操作;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        LocalDate local = LocalDate.now();
        System.out.println(local); //2019-11-05
        System.out.println("10天之后的日期是："+local.plusDays(10)); //2019-11-15
        System.out.println("3个星期之后的日期是："+local.plusWeeks(3));//2019-11-26
        System.out.println("3个月之后的日期是："+local.plusMonths(3));//2020-02-05
        System.out.println("3年之后的日期是："+local.plusYears(3));//2022-11-05

        //传入年月日 生成localDate对象
        LocalDate local2 = LocalDate.of(2019,2,3);
        System.out.println(local2);


        //字符串转日期
        LocalDate local3 = LocalDate.parse("2019-11-05");  // 2019/11/05 不行  会报异常DateTimeParseException

        //给定一个日期  得到是星期几
        System.out.println(local3.getDayOfWeek()); //TUESDAY

        //日期转String
        String str = local3.toString();


        //日期之间比较大小
        int i = local.compareTo(local3);
        System.out.println(i);  // 1   local>local3    -1: local<local3   0: local==local3

        //判断两个日期是否相等
        System.out.println(local.isEqual(local3));


        System.out.println(local3);




    }
}
