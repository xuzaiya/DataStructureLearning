package 刷题.链表;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String str[]  = new String[]{"123","23","12"};
         Arrays.stream(str).mapToInt(item->Integer.valueOf(item)).forEach(item-> System.out.println(item));
        //System.out.println(Arrays.toString(arr));
    }
}
