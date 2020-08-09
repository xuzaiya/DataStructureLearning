package 刷题;

import java.util.Scanner;

/**
 * @author xuzaiya
 * @2020/6/21 9:22
 * 文件说明:求两个数的最小公倍数
 */
public class Demo1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a  = scan.nextInt();
        int b = scan.nextInt();
        int num = min(a,b);
        System.out.println(a*b/num);
    }
    //求最大公约数
    public static int min(int a,int b){
        if(a<b){
            int t = a;
            a = b;
            b = t;
        }
        while(b!=0){
            if(a == b){
                return a;
            }else{
                int k= a%b;
                a = b;
                b = k;
            }
        }
        return a;
    }
}
