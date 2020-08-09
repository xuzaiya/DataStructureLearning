package java8.others;

import java.util.function.Function;

// 高阶函数：如果一个函数接受一个函数作为参数,或者返回一个函数作为函数返回值，那么这个函数就叫高阶函数
public class FunctionTest {
    public static void main(String[] args) {
        FunctionTest test = new FunctionTest();
        System.out.println(test.compute(1,value->{return 2*value;}));
        System.out.println(test.compute(2,value->5+value));
        System.out.println(test.compute(3,value->value*value));

        System.out.println(test.convert(5,value->value+"helloWorld"));


        //先定义好一个lambda表达式  然后传进去
        Function<Integer,Integer>function = value ->value*2;
        System.out.println(test.compute(2,function));

    }

    public int compute(int a , Function<Integer,Integer> function){
        int  result = function.apply(a);
        return result;
    }

    public String convert(int a ,Function<Integer,String> function){
        return function.apply(a);
    }


}
