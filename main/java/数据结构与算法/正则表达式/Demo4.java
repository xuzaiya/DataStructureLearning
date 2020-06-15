package 数据结构与算法.正则表达式;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo4 {
    public static void main(String[] args) {
        //拆分字符串
        /*String test = "my name is  suxing";
        String [] words = test.split(" +");
        for (String s : words){
            System.out.println(s);
        }*/


        //根据空格和逗号拆分字符串， 匹配一个空格或一个逗号
        /*String test2 = "my name is zhangsan,welcome to beijing,haha ";
        String [] words2 = test2.split("[ ,]");
        for (String s: words2){
            System.out.println(s);
        }*/

        //获取子串
        /*String test ="java 是世界上最好的语言，Java天下第一，我爱JAVA";
        String reg = "[jJ]ava|JAVA";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(test);
        while (matcher.find()){
            System.out.println(matcher.group());
        }*/

        //替换
        /*String test1 ="java 是世界上最好的语言，java天下第一，我爱JAVA";
        String reg = "[jJ]ava|JAVA";
        String test2 = test1.replaceAll(reg,"php");
        System.out.println(test2);*/

        //统计字符串出现的次数
        //appearNumber();

        //利用正则表达式 把 “我...我我...喜欢欢欢...编编程程程...” ，转换成 “我喜欢编程” ；
        /*String test1 = "我...我我...喜欢欢欢...编编程程程...";
        System.out.println(test1);
        String test2 = test1.replace(".","");
        System.out.println(test2);
        // "\\1"表示引用前面的一组表达式即 "(.)”，"$1" 表示 "\\1" ；
        String test3 = test2.replaceAll("(.)\\1+","$1");
        System.out.println(test3);*/


        // 利用正则表达式，把 “我..喜欢喜欢...编程编程编程...” ，转换成 “我喜欢编程” ；
        String test = "我..喜欢喜欢...编程编程编程...";
        String test2 = test.replace(".","");
        String test3 = test2.replaceAll("(.)(.)(\\1\\2)+","$1$2");
        System.out.println(test3);


    }

    //统计字符串出现的次数
    public static void appearNumber(){
        String str = "I wish you become better and better";
        String reg = "[e]";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(str);
        int num = 0;
        while(matcher.find()){
            num++;
        }
        System.out.println("共"+num+"个e");
    }
}
