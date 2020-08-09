package 数据结构与算法.你要掌握的题型;

/**
 * @author xuzaiya
 * @2020/8/3 15:38
 * 文件说明:求1+2!+3!+...+20!的和
 * *
*/
public class Demo18 {

    public static void main(String[] args) {
        long sum = 0;
        long fac = 1;
        for(int i=1; i<=10; i++) {
            fac = fac * i;
            sum += fac;
        }
        System.out.println(sum);

    }
}
