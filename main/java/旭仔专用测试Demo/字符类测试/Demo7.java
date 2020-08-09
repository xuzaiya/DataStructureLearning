package 旭仔专用测试Demo.字符类测试;



import 数据结构与算法.java栈.栈的应用实例.CheckExpression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.*;

/**
 * @author xuzaiya
 * @2020/7/15 8:22
 * 文件说明:
 */
public class Demo7 {
    public static void main(String[] args) {
        String s = "dkjfkdslf";
        char[] letters = s.toCharArray();
        //使用快排的方法
        char[] letter = new char[]{'a','e','i','o','u','A','E','I','O','U'};
        List<Character> list = new ArrayList<>();
        for(char ch : letter){
            list.add(ch);
        }

        for(int i=0,j=letters.length-1;i<j;)
        {
            if(!list.contains(letters[i])){
                i++;
            }else{
                if(!list.contains(letters[j])){
                    j--;
                }else{
                    char str = letters[i];
                    letters[i]= letters[j];
                    letters[j] = str;
                    i++;j--;
                }
            }


        }
        System.out.println(new String(letters));

    }
}
