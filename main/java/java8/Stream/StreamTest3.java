package java8.Stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest3 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        //list集合的遍历
        System.out.println(list.stream().map(item->item*2).reduce(0,Integer::sum));

        //System.out.println(list.stream().map(item->item*2).reduce(0,Integer::sum));
    }
}
