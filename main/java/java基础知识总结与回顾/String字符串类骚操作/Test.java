package java基础知识总结与回顾.String字符串类骚操作;

import java.util.Arrays;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        //1.新建字符串
        String str = new String("abc");
        String str2 = new String(new char[]{'a','b','c'});
        String str3 = "abc";
        String str4 = new String(new char[]{'1','a','b','c'},1,3); //从索引1开始  往后搞3个元素
        System.out.println(str);//abc
        System.out.println(str2);//abc
        System.out.println(str3);//abc
        System.out.println(str4);//abc



        //2.获取字符串的内容信息
        String str5 = "hello everyone, my name is yangxu ,i am chinese";
        System.out.println("字符串的长度是："+str5.length());//47
        System.out.println("首次出现a的索引是："+str5.indexOf('a'));//20
        System.out.println("最后一次出现a的索引是："+str5.lastIndexOf('a'));//37
        System.out.println("索引为2的字符是："+str5.charAt(2));//l


        //3.获取子字符串
        String str6 = str5.substring(20); //返回从索引2开始子字符串
        System.out.println(str6); //ame is yangxu ,i am chinese
        String str7 = str5.substring(2,5); //返回索引2到索引5的子字符串，包括2不包括5
        System.out.println(str7); //llo

        //4.去除空格
        String str8 = "    java    python   ";
        System.out.println("去掉空格后的子字符串："+str8.trim());//java    python
        System.out.println("去掉空格后的子字符串的长度是："+str8.trim().length()); //14  只去掉首尾空格


        //5.字符串替换
        String str9 = "address";
        System.out.println(str9.replace("a","A"));//Address
        System.out.println(str9);//address

        //6.判断字符串的开始于结尾
        String str10 = "yangxunihao";
        System.out.println(str10.startsWith("yang"));//true
        System.out.println(str10.endsWith("java")); //false



        //7.判断字符串是否相等
        String strs1=new String("abc");
        String strs2 = new String("ABC");
        String strs3 = "abc";
        String strs4 = new String(new char[]{'a','b','c'});
        String strs5 = "ab"+"c";

        System.out.println(strs1 == strs2); //false
        System.out.println(strs1.equals(strs2));//false
        System.out.println(strs1.equalsIgnoreCase(str2)); //true

        System.out.println(strs1==strs3); //false
        System.out.println(strs1.equals(strs3)); //true

        System.out.println(strs1==strs4); //false
        System.out.println(strs1.equals(strs4)); //true


        System.out.println(strs3==strs4); //false
        System.out.println(strs3.equals(strs4));//true

        System.out.println(strs3==strs5); //true
        System.out.println(strs3.equals(strs5)); //true


        //8.字母大小写转换
        System.out.println(strs1.toUpperCase());//ABC
        System.out.println(strs1.toLowerCase());//abc

        //9.字符串分割
        String strs6 = "192.168.0.1";
        String []arr = strs6.split("\\.");
        System.out.println(Arrays.toString(arr));//[192, 168, 0, 1]

        //10.包含子串问题
        String sqls = "yangxu";
        System.out.println(sqls.indexOf("xu"));//4  xu第一次出现的索引是4


    }
}
