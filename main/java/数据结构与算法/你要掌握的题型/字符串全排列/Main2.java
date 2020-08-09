package 数据结构与算法.你要掌握的题型.字符串全排列;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.stream.Stream;

/**
 * @author xuzaiya
 * @2020/8/8 14:03
 * 文件说明:
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba
 * <p>
 * 本题目用到了递归思想，算法步骤如下：
 * <p>
 * （1）固定第一个元素，将剩下的元素进行全排列；（那剩下的元素中又可以分为第一个和剩下的元素，这样就用到了递归）
 * <p>
 * （2）每一个字符都要有做第一个元素的机会，即将剩下的元素依次与第一个进行交换；
 * <p>
 * （3）每次交换后的数据，在进行递归处理了之后需要再交换回原来的位置，以便后面的字符与其在进行交换；
 * <p>
 * （4）在最后的按字典序输出的处理中，使用到了TreeSet和ArrayList，这两个容器相互转换时可以直接使用addAll的方法，其中TreeSet具有排序和唯一性的功能。
 */
public class Main2 {

    public static void main(String[] args) {
        String str = "abc";
        char[]data = str.toCharArray();
        HashSet<String> result = new HashSet<>();
        permutation(data,0,result);
        Stream.of(result).forEach(System.out::println);


    }

    public static void permutation(char[] data, int beginIndex, HashSet<String> result) {
        if (beginIndex == data.length-1){
            result.add(new String(data));
        }else{
            for (int i=beginIndex;i<data.length;i++){
                //如果第i个元素开始的元素相同，则两个元素就不交换
                if(i!=beginIndex && data[i] == data[beginIndex]){
                    continue;
                }

                //交换
                char temp = data[beginIndex];
                data[beginIndex] = data[i];
                data[i] = temp;
                //递归
                permutation(data,beginIndex+1,result);
                //再换回来
                temp = data[beginIndex];
                data[beginIndex] = data[i];
                data[i] = temp;
            }
        }
    }


}
