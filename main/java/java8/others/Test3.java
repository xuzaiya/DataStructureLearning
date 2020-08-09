package java8.others;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Test3 {
    public static void main(String[] args) {

        //TheInterface i1 = ()->{};
        //System.out.println(i1.getClass().getInterfaces()[0]);

        //TheInterface2 i2 = ()->{};
        //System.out.println(i2.getClass().getInterfaces()[0]);


        // lambda表达式实现
        //new Thread(()-> System.out.println("hello world")).start();

        List<String> list = Arrays.asList("hello","world","hello world");
        //list.forEach(item-> System.out.println(item.toUpperCase()));
      /*  list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s.toUpperCase());
            }
        });*/

     // List<String> list2 = new ArrayList<>(); //从jdk8 开始  new ArrayList<String>()  中  String可以省略
      //list.forEach(item->list2.add(item.toUpperCase()));
      //list2.forEach(item-> System.out.println(item));

      //list.stream().map(item->item.toUpperCase()).forEach(item-> System.out.println(item));
        //参数的类型  返回结果的类型
        // String ::toUpperCase  方法引用
      //list.stream().map(String::toUpperCase).forEach(item-> System.out.println(item));

      // interface Function(T,R ) T:代表函数的输入类型  R:代表函数的结果类型
        Function<String,String> function = String::toUpperCase; // 类::实例方法 这种形式  那么lambda表达式的第一个参数就是调用这个方法的对象
        System.out.println(function.getClass().getInterfaces()[0]);//interface java.util.function.Function
        list.stream().map(function).forEach(item-> System.out.println(item));

    }
}

@FunctionalInterface
interface TheInterface {

    void myMethod();
}

@FunctionalInterface
interface  TheInterface2{
    void myMethod2();
}
