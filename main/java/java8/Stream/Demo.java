package java8.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author xuzaiya
 * @2020/7/15 9:08
 * 文件说明:
 */
public class Demo {
    public static void main(String[] args) {
        String[] str = new String[]{"yangxu","yangxu2","yangxu3","yangxu4"};
        //方式一：
        //List<String> strList = Stream.of(str).collect(Collectors.toList());
        //Stream.of(strList).forEach(System.out::println);
        //方式二：
        //List<String> strings = Arrays.asList(str);
        //Stream.of(strings).forEach(System.out::println);

        //方式一：
        //String[] Str1 = (String[]) strList.toArray();

        //方式二：
        //String [] Str2 =(String[]) strList.stream().toArray();


        //方式一：
        for(String s : str){
            System.out.println(s);
        }
        //方式二：
        Stream.of(str).forEach(System.out::println);

        Stream.of(str).map(item->item.toUpperCase()).forEach(System.out::println);
        Stream.of(str).map(String::toUpperCase).forEach(System.out::println);



        char[] charArray = new char[]{'y','a','n','g','x','u','h','z'};
        List<Character> collect1 = new String(charArray).chars().mapToObj(i -> (char) i).collect(Collectors.toList());



    }
}
