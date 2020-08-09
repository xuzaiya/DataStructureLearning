package 旭仔专用测试Demo.字符类测试;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author xuzaiya
 * @2020/7/23 7:45
 * 文件说明:
 */
public class Demo8 {
    public static void main(String[] args) {
        String[] str = new String[]{"at","","","","ball","","","car","","","dad","",""};
        String s = Arrays.toString(str);
        System.out.println(s.indexOf("ball") );

        int a = "a".compareTo("b");//-1
        int b = "b".compareTo("b");//0
        int c = "c".compareTo("b");//1



    }
}
