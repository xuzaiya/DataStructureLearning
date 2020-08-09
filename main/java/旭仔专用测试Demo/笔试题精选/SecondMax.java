package 旭仔专用测试Demo.笔试题精选;

import java.util.Scanner;

/**
 * @author xuzaiya
 * @2020/8/1 14:37
 * 文件说明: 怎么找到一个数组中的第二大的数
 */
public class SecondMax {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();//多少个数
        int[]arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scan.nextInt();
        }
        int secondMax = getSecondMax(arr);
        System.out.println(secondMax);
    }

    public static int getSecondMax(int[] a) throws Exception {
        if(a == null || a.length <=1){
            throw new Exception("没有第二大的值");
        }
        int max1=Integer.MIN_VALUE,max2=Integer.MIN_VALUE;
        for (int i = 0; i < a.length; ++i){
            if(a[i] == max1){
                continue;
            }
            if (a[i] > max1){
                max2 = max1;
                max1 = a[i];
            } else {
                max2 = Math.max(max2, a[i]);
            }
        }

        if(max2 == Integer.MIN_VALUE){
            throw new Exception("没有第二大的值");
        }
        return max2;
    }


}
