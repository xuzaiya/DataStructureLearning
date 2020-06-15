package 数据结构与算法.正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) {
        test3();


    }

    public static void test1() {
        //表达式对象
        Pattern pattern = Pattern.compile("\\w+");
        //创建Matcher对象
        Matcher matcher = pattern.matcher("fkdjfkd&&32423");
        //boolean yesornot = matcher.matches();  //尝试将整个字符全序列与该模式匹配
        //该方法扫描输入的序列，查找与该模式匹配的下一个子序列
        //boolean yesornot2 = matcher.find();


       /* System.out.println(matcher.find());
        System.out.println(matcher.find());
        System.out.println(matcher.find());*/

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }


    public static void test2() {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher("aaa2223bb");
        m.find();//匹配2223
        m.start();//返回3
        m.end();//返回7,返回的是2223后的索引号
        m.group();//返回2223


        Matcher m2 = p.matcher("2223bb");
        m.lookingAt();   //匹配2223
        m.start();   //返回0,由于lookingAt()只能匹配前面的字符串,所以当使用lookingAt()匹配时,start()方法总是返回0
        m.end();   //返回4
        m.group();   //返回2223

        Matcher m3 = p.matcher("2223bb");
        m.matches();   //匹配整个字符串
        m.start();   //返回0,原因相信大家也清楚了
        m.end();   //返回6,原因相信大家也清楚了,因为matches()需要匹配所有字符串
        m.group();   //返回2223bb

    }

    public static void test3() {
        String s = "java123\nJAVA";//形式为"[a-z]{4}[0-9]{3}\s[A-Z]{4}
        System.out.println(s);
        System.out.println(s.matches(".+\\s.\\S+"));//测试"."匹配任意字符与空白字符"\s与非空白字符\S"
        System.out.println(s.matches("[a-z]+[1-9]+\\s[A-Z]+"));//测试[a-zA-Z0-9]的任意匹配
        System.out.println(s.matches("[^0-9]+[^a-z]+[^\\S][^a-z]+"));//测试^（非）
        System.out.println(s.matches("[bv[ja]]+[123]+\\s[A-Z&&1JAV]+"));//测试与和或
        System.out.println(s.matches("\\w{4}\\d{3}\\s\\w{4}"));//测试\w词字符与\d数字
        System.out.println(s.matches("\\D{4}\\w{3}\\W\\D{4}"));//测试非词字符\W与非数字\D

    }

    //前端常用的正则表达式汇总
    public static void test4() {

    }


}
