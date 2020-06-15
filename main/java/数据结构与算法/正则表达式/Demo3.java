package 数据结构与算法.正则表达式;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo3 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher("aa232**ddss54545**dsd223");

        //替换
        String str = matcher.replaceAll("#");
        System.out.println(str);

        //分割
        String str2 = "aa232ddss54545dsd223";
        String[] arr = str2.split("\\d+");
        System.out.println(Arrays.toString(arr));


    }
}
