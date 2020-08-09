package java8.Stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest10 {
    public static void main(String[] args) {
        // 将集合中 长度为5的字符串打印出来 并打印出第一个长度
        List<String> list = Arrays.asList("hello","world","hello world");
        //list.stream().mapToInt(item->item.length()).filter(length->length == 5).findFirst().ifPresent(System.out::println);

        list.stream().mapToInt(item->{
            int length = item.length();
            System.out.println(item);
            return length;
        }).filter(item->item == 5).findFirst().ifPresent(System.out::println);

    }
}
