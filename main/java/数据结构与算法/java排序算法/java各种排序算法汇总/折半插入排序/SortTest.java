package 数据结构与算法.java排序算法.java各种排序算法汇总.折半插入排序;

import java.util.Arrays;
/*
折半插入排序（binary insertion sort）是对插入排序算法的一种改进，由于排序算法过程中，
就是不断的依次将元素插入前面已排好序的序列中。由于前半部分为已排好序的数列，
这样我们不用按顺序依次寻找插入点，可以采用折半查找的方法来加快寻找插入点的速度。
  */
public class SortTest {
    public static void main(String[] args) {
        int[] a = {345,7,7,345,2,2,7,2,7,23,2,345,7,32,5,4,-1,3,7,2,3,2,3,4,2,1,2,4,5,3,345,3,2};
        show(a);
        insertSort2(a);
        show(a);
    }
    private static void insertSort2(int[] a) {
        for(int i=0;i<a.length-1;i++){
            int n = i+1;
            int tmp = a[n];
            if (tmp>a[i])
                continue;
            int low = 0;
            int high = i;
            int mid = (high+low)/2;
            while(high>=low){
                mid = (high+low)/2;
                if(tmp<a[mid]){
                    high = mid -1;
                }else if(tmp>a[mid]){
                    low = mid + 1;
                } else{
                    low=mid;
                    break;
                }
            }
            for(int j=n;j>mid;j--){
                a[j] = a[j-1];
            }
            a[low] = tmp;
        }
    }
    private static void show(int[] a) {
        System.out.println(Arrays.toString(a));
    }
}
