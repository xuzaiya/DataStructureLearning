package java8.others;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello","world","hello world");
        list.forEach(item-> System.out.println(item));

        // Consumer  里面有一个accept方法   接收一个参数 不返回任何值
        /*list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });*/
        // 方法引用
        list.forEach(System.out::println);
        /* 我们可以将 方法引用看做是一个函数指针
         方法引用的分类：
            四类：
            （1）类名::静态方法名
            (2)引用名（对象名）::实例方法名
            (3)类名::实例方法名
         */
    }
}
