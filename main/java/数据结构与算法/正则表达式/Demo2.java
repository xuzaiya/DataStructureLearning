package 数据结构与算法.正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo2 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("([a-z]+)([0-9]+)");
        Matcher matcher = pattern.matcher("aa232**ddss54545**dsd223");
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
