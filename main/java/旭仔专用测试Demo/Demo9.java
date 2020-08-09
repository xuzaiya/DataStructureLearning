package 旭仔专用测试Demo;

import java.awt.datatransfer.StringSelection;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author xuzaiya
 * @2020/7/16 8:58
 * 文件说明:
 */
public class Demo9 {
    public static void main(String[] args) {

        //1、Object数组转成String数组
        Object[] obj = new Object[]{"yangxu","zengyang","dayang","xiaoyang"};
        //第一种
        String[] str1 = Arrays.stream(obj).toArray(String[]::new);
        //第二种
        String[] str2 = Arrays.asList(obj).toArray(new String[0]);
        //第三种
        String[] str3 = Arrays.copyOf(obj, obj.length, String[].class);
        //第四种
        String[] str4 = Stream.of(obj).toArray(String[]::new);


        //2、Set集合转String数组
        Set<String> set = new HashSet<>();
        set.add("yangxu1");
        set.add("yangxu2");
        set.add("yangxu3");
        set.add("yangxu5");
        //1、第一种
        String[] str5 = set.stream().toArray(String[]::new);
        //2.第二种
        String[] str6 = set.toArray(new String[0]);




        //3、List<Integer>转 int数组
        List<Integer> list = new ArrayList<>();
        list.add(27);
        list.add(26);
        list.add(25);
        list.add(24);
        list.add(23);
        //方法1
        int[] int_1 = list.stream().mapToInt(Integer::intValue).toArray();
        //方法2
        int[] int_2 = list.stream().mapToInt(Integer::valueOf).toArray();



    }

}
