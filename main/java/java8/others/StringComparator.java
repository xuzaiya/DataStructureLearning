package java8.others;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringComparator {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("zhangsan","lisi","wangwu","zhaoliu");
        // 倒叙排序
        /*Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        System.out.println(names);*/


        //凡是函数式接口  可以用lambda代替   灰的代表冗余的代码
        /*Collections.sort(names,(String o1,String o2)->{
            return o2.compareTo(o1);
        });
        System.out.println(names);*/
        //Collections.sort(names,(o1,o2)->  o2.compareTo(o1));

        // 修改上面冗余的代码   reverseOrder() 是定义在接口里面的一个静态的方法
        Collections.sort(names,Comparator.reverseOrder());
        System.out.println(names);

        // lambda表达式是一种匿名函数；它是没有声明的方法，即没有访问修饰符，返回值声明和名字
        //lambda表达式作用：传递行为，而不仅仅是值， 提升抽象层次，API重用性更好，更加灵活
        /*
        （int a ,int b）->{return a+b}
        ()->System.out.println("HelloWorld");
        (String s)->{System.out.println(s);}
        (String s ) -> {System.out.println(s);}
        () -> 42   不接收参数， 返回42

        当只有是一个参数的时候，并且类型可以推导  （） 括号可以省略  a->return a*a;
        当主体只有一条语句  {} 花括号  可以省略  return 也可以省略

        两种风格：
                expression: o2.compareTo(o1)  不能有分号
                statement:  {return o2.compareTo(o1);}
         */
    }
}
