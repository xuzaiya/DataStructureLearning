package java8.others;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*函数式接口
 （1）如果我们在某个接口上声明了@FunctionalInterface注解 ，那么编译器就会按照函数式接口的定义来要求该接口
 （2）有且仅有一个抽象方法的接口
 （3）只有一个抽象的方法，没有标注注解，那么编译器任然会将该接口视为函数式接口
 */
// 如果一个接口是函数式接口  那么就可以用lambda表达式去生成接口的实例
// 函数式接口的实例 可以通过lambda表达式创建 方法引用  或者是构造方法引用  三种途径实现
public class Test1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,67,8);

        //遍历list
        /*for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        System.out.println("==========");

        for (Integer i: list){
            System.out.println(i);
        }

        System.out.println("==========");*/

         // 第三种  Consumer  接收一个参数没有返回值
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });


        //遍历 lambda表达式
        //list.forEach(i-> System.out.println(i));

        //通过方法引用的方式  method reference
        //list.forEach(System.out::println);

    }
}
