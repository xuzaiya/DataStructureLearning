package 数据结构与算法.java排序算法.java各种排序算法汇总.希尔排序;

import java.util.Arrays;
/*
前言：希尔排序(Shell Sort)是插入排序的一种。是针对直接插入排序算法的改进。该方法又称缩小增量排序，因DL．Shell于1959年提出而得名。本文主要介绍希尔排序用Java是怎样实现的。

希尔排序(缩小增量法) 属于插入类排序,是将整个无序列分割成若干小的子序列分别进行插入排序。希尔排序并不稳定，O(1)的额外空间，时间复杂度为O(N (logN)^2)。最坏的情况下的执行效率和在平均情况下的执行效率相比相差不多。

基本思想：

先取一个小于n的整数d1作为第一个增量，把文件的全部记录分成d1个组。所有距离为d1的倍数的记录放在同一个组中。先在各组内进行直接插入排序；然后，取第二个增量d2<d1重复上述的分组和排序，直至所取的增量dt=1(dt<dt-l<…<d2<d1)，即所有记录放在同一组中进行直接插入排序为止。
  */
public class SortTest {
    public static void main(String[] args) {
        int[] a = {345,7,32,5,4,-1,3,2,3,5,7,8,90,1};
        show(a);
        shellSort(a);
        show(a);
    }
    private static void shellSort(int[] a) {
        shellSort(a,a.length);
    }
    private static void shellSort (int[] a, int n){
        int i, j, k, temp, gap;
        int[] gaps = { 1,5,13,43,113,297,815,1989,4711,11969,27901,84801,
                213331,543749,1355339,3501671,8810089,21521774,
                58548857,157840433,410151271,1131376761,2147483647 };
        for (k=0; gaps[k]<n; k++);
        while (--k >= 0){
            gap = gaps[k];
            for (i=gap; i<n; i++){
                temp = a[i];
                j = i;
                while (j>=gap && a[j-gap]>temp){
                    a[j] = a[j-gap];
                    j = j-gap;
                }
                a[j] = temp;
            }
        }
    }
    private static void show(int[] a) {
        System.out.println(Arrays.toString(a));
    }

    /*public static int[] sort(int[] ins){
        int n = ins.length;
        int gap = n/2;
        while(gap>0){
            for (int j=gap;j<n;j++){


            }
        }
    }*/




}
