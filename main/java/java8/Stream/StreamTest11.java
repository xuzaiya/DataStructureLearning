package java8.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest11 {
    public static void main(String[] args) {
        // 找出所有的单词去重
        List<String> list = Arrays.asList("hello welcome","world hello","hello world hello","hello welcome");

        //List<String[]> result = list.stream().map(item->item.split(" ")).collect(Collectors.toList());
        //result.forEach(item->Arrays.asList(item).forEach(System.out::println));

        list.stream().map(item->item.split(" ")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()).forEach(System.out::println);
        list.stream().map(item->item.split(" ")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()).forEach(System.out::println);

    }
}
