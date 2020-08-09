package java8.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// stream 分组与分区
public class StreamTest12 {
    public static void main(String[] args) {

        // faltMap 和 map 的合理应用
        List<String> list1 = Arrays.asList("Hi","Hello","你好");
        List<String> list2 = Arrays.asList("zhangsan","lisi","wangwu","zhao liu");
        list1.stream().flatMap(item->list2.stream().map(item2->item+" "+ item2)).collect(Collectors.toList()).forEach(System.out::println);

    }
}
