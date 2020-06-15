package 数据结构与算法.java排序算法.java各种排序算法汇总.选择排序;

import java.util.Arrays;
/*
选择排序的基本操作就是每一趟从待排序的数据元素中选出最小（或最大）的一个元素，顺序放在已排好序的数列的最后，直到全部待排序的数据元素排完。算法不稳定，O(1)的额外的空间，比较的时间复杂度为O(n^2)，交换的时间复杂度为O(n)，并不是自适应的。在大多数情况下都不推荐使用。只有在希望减少交换次数的情况下可以用。

基本思想

n个记录的文件的直接选择排序可经过n-1趟直接选择排序得到有序结果：
①初始状态：无序区为R[1..n]，有序区为空。
②第1趟排序
在无序区R[1..n]中选出关键字最小的记录R[k]，将它与无序区的第1个记录R[1]交换，使R[1..1]和R[2..n]分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区。
……
③第i趟排序

第i趟排序开始时，当前有序区和无序区分别为R[1..i-1]和R(1≤i≤n-1)。该趟排序从当前无序区中选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区。
这样，n个记录的文件的直接选择排序可经过n-1趟直接选择排序得到有序结果。
  */
public class SortTest {
    public static void main(String[] args) {
        int[] a = {345,7,32,5,4,-1};
        show(a);
        selectSort(a);
        show(a);
    }
    private static void selectSort(int[] a) {
        for (int i = 0; i < a.length-1; i++) {
            int min = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[j]<a[min])
                    min = j;
            }
            if (min!=i){
                int tmp = a[i];
                a[i] = a[min];
                a[min] = tmp;
            }
        }
    }

    private static void selectSort2(int[]arr){
        for (int i =0;i<arr.length-1;i++){
            int min = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]>arr[min]){
                    min = j;
                }
            }
            if(min!=i){
                int temp =arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    private static void selectSort3(int[]arr){
        for (int i = 0 ;i<arr.length-1;i++){
            int min = i;
            for(int j = i+1;j<arr.length;i++){
                if(arr[j]>arr[min]){
                    min = j;
                }
            }
            if (min!=i){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }


    private static void selectSort4(int[]arr){
        for (int i =0;i<arr.length-1;i++){
            int min = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]>arr[min]){
                    min = j;
                }
            }
            if(min!=i){
                int temp =arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    private static void selectSort5(int[]arr){
        for (int i = 0 ;i<arr.length-1;i++){
            int min = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]>arr[min]){
                    min  = j;
                }
            }
            if(min!=i){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] =temp;
            }
        }
    }


    private static void selectSort6(int[]arr){
        for (int i=0;i<arr.length-1;i++){
            int min = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]>arr[min]){
                    min = j;
                }
            }
            if(i!=min){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }










    private static void show(int[] a) {
        System.out.println(Arrays.toString(a));
    }





}
