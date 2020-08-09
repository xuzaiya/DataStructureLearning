package java8.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest4 {
    public static void main(String[] args) {
        Stream<String> stream  = Stream.of("hello","world","hello world");
        //把流转换成一个数组
        String[] stringArrays = stream.toArray(length->new String[length]);
        String[] stringArrays1 = stream.toArray(String[]::new);





        Arrays.asList(stringArrays1).forEach(System.out::println);
        //List<String> stirnglist = Arrays.asList(stringArrays1);



        List<String> list = stream.collect(Collectors.toList());

        List<String> list2 = stream.collect(()->new ArrayList(),(theList, item)->theList.add(item),
                (theList,theList2)->theList.addAll(theList2));

        /*Stream<String> stream = Stream.of("hello","world","hello world");
        //流转换成list
        List<String> list = stream.collect(Collectors.toList());
        list.forEach(System.out::println);*/

        /*Stream<String> stream = Stream.of("hello","world","hello World");
        *//* collect方法接收三个参数
            Supplier<R>supplier: 没有参数 返回一个结果
            BiConsumer<R,? super T> accumplator:  accumplator 叫累加器  对集合中每个元素进行遍历，然后把每个元素应用到这个结果上面
            BiConsumer<R,R> combiner:    combiner:叫合并器  ：将上一次的操作结果和下一次的操作结果合并到一起
         *//*
        List<String> list = stream.collect(()->new ArrayList(),(theList,item)->theList.add(item),
                (theList,theList2)->theList.addAll(theList2));
        list.forEach(System.out::println);*/



        /*// 流转换成list
        Stream<String> stream = Stream.of("hello","world","hello World");
        //List<String> list = stream.collect(LinkedList::new,LinkedList::add,LinkedList::addAll);
        List<String>list1 = stream.collect(ArrayList::new,ArrayList::add,ArrayList::addAll);
        list1.forEach(System.out::println);*/

        /*//把流里面的多个字符串拼接成一个字符串
        Stream<String> stream = Stream.of("hello","world","hello World");
        //String contact = stream.collect(Collectors.joining());
        String contact = stream.collect(StringBuffer::new,StringBuffer::append,StringBuffer::append).toString();
        System.out.println(contact);*/



        // 流转变成List集合
        /*Stream<String> stream = Stream.of("hello","world","hello World");
        List<String> list = stream.collect(Collectors.toCollection(ArrayList::new));
        list.forEach(System.out::println);*/


        // 流转变成Set集合
        //Stream<String> stream = Stream.of("hello","world","hello World");
        //Set<String> set = stream.collect(Collectors.toCollection(TreeSet::new));
        //System.out.println(set.getClass());
        //set.forEach(System.out::println);//hello  hello World  world  TreeSet本身是带排序的，不指定默认按照字母的升序

    }
}
