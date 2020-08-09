package 旭仔专用测试Demo;

import java.util.Scanner;

/**
 * @author xuzaiya
 * @2020/7/31 19:11
 * 文件说明:
 */
public class Cow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();//多少只牛
        int m = scan.nextInt();//所少中颜色
        int fun = fun(n, m);
        System.out.println(fun);

    }

    public static int fun(int n, int m)
    {
        if(n<m)
            return -1;
        else if(m == 0)
            return 0;
        else if(n == m)
            return 1;
        else
            return m*fun(n-1,m) + fun(n-1, m-1);
    }

    public static int function(int m){
        int sum = 1;
        for(int i=1;i<=m;i++){
            sum=sum*i;
        }
        return sum;
    }
}




