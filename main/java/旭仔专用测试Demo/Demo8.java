package 旭仔专用测试Demo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author xuzaiya
 * @2020/7/16 8:58
 * 文件说明:
 */
public class Demo8 {
    public static void main(String[] args) {

        //(1)把这个arr数组转换成list，你能想到几种写法

        //第一种
        int[] arr = new int[]{1,2,3,4,5,6};
        List<Integer> list = new ArrayList<>();
        for(int i : arr){
            list.add(i);
        }
        //第二种
       List<Integer> list2 =  Arrays.stream(arr).boxed().collect(Collectors.toList());




       //第1种
        Integer[] arr2 = new Integer[]{3,5,68,44};
        List<Integer> list3 = Arrays.asList(arr2);
        //第2种
        List<Integer> list4= new ArrayList<>(arr2.length);
        Collections.addAll(list3, arr2);
        //第3种
        List<Integer> list5 = Stream.of(arr2).collect(Collectors.toList());
        //第4种
        List<Integer> list6 = Arrays.stream(arr2).collect(Collectors.toList());


    }

}
