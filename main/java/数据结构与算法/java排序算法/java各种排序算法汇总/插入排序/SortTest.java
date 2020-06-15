package 数据结构与算法.java排序算法.java各种排序算法汇总.插入排序;

import java.util.Arrays;
/*
本文实例讲述了Java插入排序方法。分享给大家供大家参考。具体分析如下：

有一个已经有序的数据序列，要求在这个已经排好的数据序列中插入一个数，但要求插入后此数据序列仍然有序，这个时候就要用到插入排序法。本文主要介绍的是插入排序的java实现。

插入排序的基本操作就是将一个数据插入到已经排好序的有序数据中,从而得到一个新的、个数加一的有序数据。比较和交换的时间复杂度为O(n^2)，算法自适应，对于数据已基本有序的情况，时间复杂度为O(n)，算法稳定，开销很低。算法适合于数据已基本有序或者数据量小的情况。

插入算法把要排序的数组分成两部分：第一部分包含了这个数组的所有元素，但将最后一个元素除外，而第二部分就只包含这一个元素。在第一部分排序后，再把这个最后元素插入到此刻已是有序的第一部分里的位置。

算法描述

一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：

1. 从第一个元素开始，该元素可以认为已经被排序
2. 取出下一个元素，在已经排序的元素序列中从后向前扫描
3. 如果该元素（已排序）大于新元素，将该元素移到下一位置
4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
5. 将新元素插入到下一位置中
6. 重复步骤2

如果比较操作的代价比交换操作大的话，可以采用二分查找法来减少比较操作的数目。该算法可以认为是插入排序的一个变种，称为二分查找排序。
  */
public class SortTest {
    public static void main(String[] args) {
        int[] a = {345,7,32,5,4,-1,3};
        show(a);
        insertSort3(a);
        show(a);
    }
    private static void insertSort(int[] a) {
        for(int i=0;i<a.length-1;i++){
            int n = i+1;
            int tmp = a[n];
            for(int j=i;j>=0;j--){
                if(tmp<a[j]){
                    a[n] = a[j];
                    n=j;
                }
            }
            if (a[n]!=tmp)
                a[n] = tmp;
        }
    }
    private static void show(int[] a) {
        System.out.println(Arrays.toString(a));
    }

    // 从零开始排序
    private static void insertSort2(int[] a){
        for (int i=0;i<a.length-1;i++){
            int n =i+1;
            int temp = a[n];
            for (int j=i;j>=0;j--){
                if (temp<a[j]){
                    a[n] = a[j];
                    n=j;
                }
            }

            if (a[n]!=temp){
                a[n] = temp;
            }
        }
    }
    // 默认第一个是有序的
    private static void insertSort3(int[] a){
        for (int i=1;i<a.length;i++){
            int j=i-1;
            int temp = a[i];
            while(j>=0&&a[j]>temp){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = temp;
        }
    }

    //默认第一个是有序的
    private static void insertSort4(int[]a){
        for (int i=0;i<a.length;i++){
            int j=i-1;
            int temp = a[i];
            while(j>=0&&a[j]>temp){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = temp;
        }
    }

    //默认第一个是有序的
    private  static void insertSort5(int[]arr){
        for (int i = 0;i<arr.length;i++){
            int j = i-1;
            int temp = arr[i];
            while(j>=0&&arr[j]>temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }


    //默认第一个是有序的
    private static void insertSort6(int[]arr){
        for (int i = 0 ;i<arr.length;i++){
            int j = i-1;
            int value = arr[i];
            while(j>=0&&arr[j]>value){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = value;
        }
    }

    //默认第一个是有序的
    private static void insertSort7(int[]arr){
        for (int i = 0 ;i<arr.length;i++){
            int j = i-1;
            int temp = arr[i];
            while(j>=0&&arr[j]>temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }

    //默认第一个是有序的
    private static void insertSort8(int[]arr){
        for (int i=0;i<arr.length;i++){
            int j = i-1;
            int temp = arr[i];
            while(j>=0&&arr[j]>temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }

    //默认第一个是有序的
    private static void insertSort9(int[]arr){
        for (int i=0;i<arr.length;i++){
            int j = i-1;
            int temp = arr[i];
            while(j>=0&&arr[j]>temp){
                arr[j+1] =arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }

    //默认第一个是有序的
    private static void insertSort10(int[]arr){
        for (int i=0;i<arr.length;i++){
            int j=i-1;
            int temp = arr[i];
            while(j>=0&&arr[j]>temp){
                arr[j+1] = arr[j];
            }
            arr[j+1] = temp;
        }
    }


    //插入排序
    private static void insetSort(int[]arr){
        for(int i=0;i<arr.length;i++){
            int j= i-1;
            int value = arr[i];
            while(j>=0&&arr[j]>value){
                arr[j+1] = arr[j];
            }
            arr[j+1] = value;
        }
    }












}
