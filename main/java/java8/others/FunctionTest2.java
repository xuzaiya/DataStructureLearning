package java8.others;

import java.util.function.BiFunction;
import java.util.function.Function;

// 学习Function接口里面的 compose 和 andThen方法
// Function接口  里面的apply 方法  接收一个参数  返回一个结果
//如果接收两个参数  返回一个值的话    要学习这个接口  BiFunction    就是Bidirectional  双向的意思

public class FunctionTest2 {
    public static void main(String[] args) {
        FunctionTest2 functionTest2 = new FunctionTest2();
        System.out.println(functionTest2.compute(2,value->value*3,value->value*value)); //12
        System.out.println(functionTest2.compute2(2,value->value*3,value->value*value)); //36


        //加
        System.out.println(functionTest2.compute3(2,3,(a,b)->a+b));
        //减
        System.out.println(functionTest2.compute3(2,3,(a,b)->a-b));
        //乘
        System.out.println(functionTest2.compute3(2,3,(a,b)->a*b));
        //除
        System.out.println(functionTest2.compute3(2,3,(a,b)->a/b));

        //biFunction 的 andThen
        System.out.println(functionTest2.compute4(2,3,(a,b)->a+b,c->c*c));//25

    }

    public int compute(int a, Function<Integer,Integer>function1,Function<Integer,Integer>function2){
        //compose是 先执行参数function2的apply  后作为function1 的apply 的输入
        return function1.compose(function2).apply(a);
    }

    // compose  和 andThen  可以实现函数的这种串联
    // compose 后面可以跟compose andThen   andthen 后面又可以跟andThen 或者compose
    public int compute2(int a, Function<Integer,Integer>function1,Function<Integer,Integer>function2){
        // andThen 是限制性function1的apply 然后作为参数执行 function2的 apply
        return function1.andThen(function2).apply(a);
    }


    // 求两个整数的和
    public int compute3(int a, int b, BiFunction<Integer,Integer,Integer>bifunction){
        int result = bifunction.apply(a,b);
        return result;
    }

    //BiFunction 的 andThen
    public int compute4(int a,int b,BiFunction<Integer,Integer,Integer>biFunction,Function<Integer,Integer>function){

        return biFunction.andThen(function).apply(a,b);
    }



}
