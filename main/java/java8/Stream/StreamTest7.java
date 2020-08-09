package java8.Stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest7 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello","world","yangxu");
        // 流的终止操作  或者是及早操作
        //list.stream().map(item->item.substring(0,1).toUpperCase()+item.substring(1)).forEach(System.out::println);

        // 流的中间操作  惰性求值  遇到终止操作 中间操作才会执行
        list.stream().map(item->{
            String result = item.substring(0,1).toUpperCase()+item.substring(1);
            System.out.println(result);
            return result;
        });
    }
}
