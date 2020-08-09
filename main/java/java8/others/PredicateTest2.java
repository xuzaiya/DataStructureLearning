package java8.others;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest2 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        PredicateTest2 predicateTest2 = new PredicateTest2();
        //偶数
        //predicateTest2.conditionFilter(list,item->item%2 == 0);
        //predicateTest2.conditionFilter(list,item->item%2 !=0);
        //predicateTest2.conditionFilter(list,item->item>5);
        // 打印所有的元素
        //predicateTest2.conditionFilter(list,item->true);


        //找出当前集合当中大于5 并且是偶数的数字
        //predicateTest2.conditionFilter2(list,item->item>5,item->item%2==0);

        // 找出当前集合当中大于5 或者是偶数的数字
        //predicateTest2.conditionFilter3(list,item->item>5,item->item%2==0);

        // 找出当前集合当中不大于5
        predicateTest2.conditionFilter4(list,item->item>5);


        System.out.println(predicateTest2.isEqule("test").test("test"));

        System.out.println(Predicate.isEqual("test").test("test"));
    }

    public void conditionFilter(List<Integer>list, Predicate<Integer>predicate){
        for (Integer integer: list){
            if(predicate.test(integer)){
                System.out.println(integer);
            }
        }
    }


    public void conditionFilter2(List<Integer> list,Predicate<Integer> predicate,Predicate<Integer>predicate2){
        for (Integer integer : list){
            if (predicate.and(predicate2).test(integer)){
                System.out.println(integer);
            }
        }

    }

    public void conditionFilter3(List<Integer> list,Predicate<Integer> predicate,Predicate<Integer>predicate2){
        for (Integer integer : list){
            if (predicate.or(predicate2).test(integer)){
                System.out.println(integer);
            }
        }

    }

    public void conditionFilter4(List<Integer> list,Predicate<Integer> predicate){
        for (Integer integer : list){
            if (predicate.negate().test(integer)){
                System.out.println(integer);
            }
        }

    }


    public Predicate<String> isEqule(Object object){
        return Predicate.isEqual(object);
    }


}
