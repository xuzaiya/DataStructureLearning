package 数据结构与算法.你要掌握的题型;

import java.util.Scanner;

/**
 * @author xuzaiya
 * @2020/8/3 15:08
 * 文件说明: 输入两个数，求最大公约数和最小公倍数
 */
public class Demo5 {
    public static void main(String[] args) {
        int a, b;
        Scanner scan = new Scanner(System.in);
        a = scan.nextInt();
        b = scan.nextInt();
        int m = division(a,b);
        int n = a*b/m;
        System.out.println("最大公约数："+m);
        System.out.println("最小公倍数："+n);
    }
    public static int division(int x, int y) {
        int t;
        if(x < y) {
            t = x;
            x = y;
            y = t;
        }
        while(y != 0) {
            if(x == y) return 1;
            else {
                int k = x % y;
                x = y;
                y = k;
            }
        }
        return x;
    }

}
