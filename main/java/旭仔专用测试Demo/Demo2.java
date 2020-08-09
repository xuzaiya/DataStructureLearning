package 旭仔专用测试Demo;

import java.util.*;

public class Demo2 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1};
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]);
        }
        System.out.println(sb.toString());





    }
    public static  List<String> func(String str){
        int len = str.length();
        List<String> list2 = new ArrayList<>();
        for(int i=0;i<len;i++){
            char ch = str.charAt(i);
            String s  =str.substring(0,i)+str.substring(i,len);
            List<String> list = func(s);
            for (String ss :list){
                list2.add(""+ch+ss);
            }
        }
        return list2;
    }
}
