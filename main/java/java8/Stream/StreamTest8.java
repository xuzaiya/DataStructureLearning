package java8.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamTest8 {
    public static void main(String[] args) {
        // distinct 去重
        IntStream.iterate(0, i->(i+1)%2).distinct().limit(6).forEach(System.out::println);
        //IntStream.iterate(0,i->i+2).limit(6).forEach(System.out::println);
        List<String> list = Arrays.asList("hello","world","hello world");
        list.stream().map(item->item.substring(0,1).toUpperCase()+item.substring(1)).forEach(System.out::println);
        //list.stream().map(item->item.substring(0,1).toUpperCase()+item.substring(1)).forEach((item)-> System.out.println(item));

    }
}
