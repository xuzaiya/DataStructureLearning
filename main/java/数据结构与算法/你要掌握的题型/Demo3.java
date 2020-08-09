package 数据结构与算法.你要掌握的题型;

/**
 * @author xuzaiya
 * @2020/8/3 12:49
 * 文件说明:打印出所有的"水仙花数(narcissus number)"，所谓"水仙花数"是指一个三位数
 */
public class Demo3 {
    static int b, bb, bbb;
    public static void main(String[] args) {
        for(int num=101; num<1000; num++) {
            f(num);
        }
    }
    public static void f(int m) {
        bbb = m / 100;
        bb = (m % 100) / 10;
        b = (m % 100) % 10;
        if((bbb * bbb * bbb + bb * bb * bb + b * b * b) == m) {
            System.out.println(m);
        }
    }
}
