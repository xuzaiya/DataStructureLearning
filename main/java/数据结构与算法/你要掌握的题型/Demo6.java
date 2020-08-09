package 数据结构与算法.你要掌握的题型;

import java.util.Scanner;

/**
 * @author xuzaiya
 * @2020/8/3 15:16
 * 文件说明: 输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
 */
public class Demo6 {
    static int digital = 0;
    static int character = 0;
    static int other = 0;
    static int blank = 0;
    public static void main(String[] args) {
        char[] ch = null;
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        ch = s.toCharArray();
        for(int i=0; i<ch.length; i++) {
            if(ch[i] >= '0' && ch[i] <= '9') {
                digital ++;
            } else if((ch[i] >= 'a' && ch[i] <= 'z') || ch[i] > 'A' && ch[i] <= 'Z') {
                character ++;
            } else if(ch[i] == ' ') {
                blank ++;
            } else {
                other ++;
            }
        }
        System.out.println("数字个数: " + digital);
        System.out.println("英文字母个数: " + character);
        System.out.println("空格个数: " + blank);
        System.out.println("其他字符个数:" + other );
    }

}
