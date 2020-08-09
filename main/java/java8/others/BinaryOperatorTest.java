package java8.others;


import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorTest {
    public static void main(String[] args) {

        BinaryOperatorTest binaryOperatorTest = new BinaryOperatorTest();
        int result = binaryOperatorTest.compute(2,3,(a,b)->a+b);
        System.out.println(result);

        // 返回两个字符串中较小的一个
        System.out.println(binaryOperatorTest.getShort("nihao","yangxu",(String s1,String s2)->s1.length()-s2.length()));

        // 返回两个 字符串 首字母的ASCII值较小的一个
        System.out.println(binaryOperatorTest.getShort("hello123","world",(a,b)->a.charAt(0)-b.charAt(0)));

    }

    // 传入两个参数  返回一个相同类型的结果
    public int compute(int a, int b, BinaryOperator<Integer>binaryOperator){
        int result = binaryOperator.apply(a,b);
        return result;
    }

    // 传入两个参数，返回最小的一个
    public String getShort(String a, String b, Comparator<String> comparator){
        return BinaryOperator.minBy(comparator).apply(a,b);
    }

    // 传入两个参数，返回最小的一个


}
