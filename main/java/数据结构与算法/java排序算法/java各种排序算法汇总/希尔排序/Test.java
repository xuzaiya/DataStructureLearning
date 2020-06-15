package 数据结构与算法.java排序算法.java各种排序算法汇总.希尔排序;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] array = new int[n];
        //数据输入
        for (int i=0;i<n;i++){
            array[i] = scan.nextInt();
        }

        //选择排序
        for (int i=0;i<array.length-1;i++){
            int min = i;
            for (int j=i+1;j<array.length;j++){
                if (array[j]<array[min]){
                    min=j;
                }
            }
            if(min!=i){
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
        int temp = 0;
        for (int i=0;i<k;i++){

            for (int j =0;j<array.length;j++){
               if (array[j]>0){
                   temp = array[j];
                   System.out.println(temp);
                   break;
               }

            }
            for (int p=0;p<array.length;p++){
                array[p] =array[p]-temp;
            }



        }





    }
}
