package 旭仔专用测试Demo.贝壳;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xuzaiya
 * @2020/7/29 13:52
 * 文件说明:
 */
public class Demo4 {
    public static void main(String[] args) {
        prob1();
    }

    public static  void prob1(){
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int s=in.nextInt();
        int[] c=new int[n];
        for(int i=0;i<n;i++){
            c[i]=in.nextInt();
        }
        Arrays.sort(c);
        int re=0;
        int p=0;
        while(s>0 && s>=c[p]){
            s-=c[p];
            re++;
            p++;
        }
        System.out.println(re);
    }
}
