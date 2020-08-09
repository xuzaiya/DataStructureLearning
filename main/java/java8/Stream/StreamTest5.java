package java8.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamTest5 {
    public static void main(String[] args) {
        // 将集合中的每个字符串  转换成大写
       /* List<String> list = Arrays.asList("hello","world","hello world");
        //list.stream().map(item->item.toUpperCase()).forEach(System.out::println);
        //list.stream().map(String::toUpperCase).forEach(System.out::println);
        list.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);*/

        // 将集合中的每个元素  求个平方  在打印出来
        /*List<Integer> list1 = Arrays.asList(1,2,3,4,5,6);
        //list1.stream().map(item->item*item).forEach(System.out::println);
        list1.stream().map(item->(int)Math.pow(item,2)).forEach(System.out::println);*/

        // flatMap  就是将里面的几个list 搞成一个list
        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1,2,3),Arrays.asList(2,3),Arrays.asList(3,4,5,6,7));
        List<Integer> list = stream.flatMap(theList->theList.stream()).collect(Collectors.toList());
        list.stream().forEach(System.out::println);
        // 一步搞成功
        stream.flatMap(theList->theList.stream()).map(item->item*item).forEach(System.out::println);




    }
}
