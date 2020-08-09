package java8.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        // 创建一个流 第一种方式
        Stream stream  = Stream.of("hello","world","hello world");

        // 创建一个流  第二种方式
        String [] myArray = new String[]{"hello","world","hello world"};
        Stream stream1 = Stream.of(myArray);
        // 第三种
        Stream stream2 = Arrays.stream(myArray);

        // 第四种
        List<String> list = Arrays.asList(myArray);
        Stream stream3 = list.stream();
    }
}
