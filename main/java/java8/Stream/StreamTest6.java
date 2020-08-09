package java8.Stream;

import java.util.IntSummaryStatistics;
import java.util.stream.Stream;

public class StreamTest6 {
    public static void main(String[] args) {


        /*Stream<String> stream = Stream.generate(UUID.randomUUID()::toString);
        // findFirst()方法 返回值Optional对象  是为了规避当流中没有元素的时候返回null的问题
        System.out.println(stream.findFirst()); //找到第一个元素  后面不管  findFirst返回流里面的第一个元素
        stream.findFirst().ifPresent(System.out::println); // ifPresent 当存在元素时输出  ，不存在 啥也不干
        */

        // iterator迭代   limit 限制只产生几个
        //Stream.iterate(1,item->item+2).limit(6).forEach(System.out::println);

        /*// 将Stream.iterate(1,item->item+2).limit(6) 产生的元素 找出大于2的 乘以2  忽略掉前两个元素  最后再去两个元素求和 输出
        int sum = Stream.iterate(1,item->item+2).limit(6).filter(item->item>2).mapToInt(item->item*2).skip(2).limit(2).sum();
        System.out.println(sum);*/

        // 将Stream.iterate(1,item->item+2).limit(6) 产生的元素 找出大于2的 乘以2  忽略掉前两个元素   求出最小值 输出
        //Stream.iterate(1,item->item+2).limit(6).filter(item->item>2).mapToInt(item->item*2).skip(2).min().ifPresent(System.out::println);

        //当想要同时求出 最小值  最大值  总和
        IntSummaryStatistics summaryStatistics = Stream.iterate(1, item->item+2).limit(6).filter(item->item>2).mapToInt(item->item*2).summaryStatistics();
        System.out.println(summaryStatistics.getMax());
        System.out.println(summaryStatistics.getMin());
        System.out.println(summaryStatistics.getMax());
        System.out.println(summaryStatistics.getAverage());
        System.out.println(summaryStatistics.getSum());
        System.out.println(summaryStatistics.getCount());

    }
}
