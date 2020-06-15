package 数据结构与算法.java排序算法.java各种排序算法汇总.归并排序;

import java.util.Arrays;
/*
归并操作(merge)，也叫归并算法，指的是将两个已经排序的序列合并成一个序列的操作。和快速排序类似，让我们一起来看，归并在Java中的实现。

归并排序（Merge）是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。

归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。

归并排序算法稳定，数组需要O(n)的额外空间，链表需要O(log(n))的额外空间，时间复杂度为O(nlog(n))，算法不是自适应的，不需要对数据的随机读取。

工作原理：

1、申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
2、设定两个指针，最初位置分别为两个已经排序序列的起始位置
3、比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
4、重复步骤3直到某一指针达到序列尾
5、将另一序列剩下的所有元素直接复制到合并序列尾
  */
public class SortTest {
    public static void main(String[] args) {
        int[] a = {345,7,32,5,4,-1,3,2,3,5,7,8,90,1,432,1};
        show(a);
        mergeSort(a);
        show(a);
    }
    private static void mergeSort(int[] a) {
        //找出中间值
        int mid = a.length/2;
        //申请空间存储中间索引以左的值
        int[] left = setValue(a,0,mid);
        if (left.length>1){//继续拆分左边，直到元素值为1个
            mergeSort(left);
        }
        //申请空间存储中间索引以右的值
        int[] right = setValue(a,mid,a.length);
        if (right.length>1){//继续拆分右边，直到元素值为1个
            mergeSort(right);
        }
        //将左右值合并
        merge(a,left,right);
    }


    private static void mergeSort2(int[]arr){
        //找出中间值
        int mid = arr.length/2;
        //申请空间存储索引以左的值
        int[] left = setValue(arr,0,mid);
        if(left.length>1){
            mergeSort2(left);
        }
        //申请空间存储索引以右的值
        int[] right = setValue(arr,mid,arr.length);
        if(right.length>1){
            mergeSort2(right);
        }

        //将左右值合并
        merge(arr,left,right);

    }



    private static void merge(int[] a , int[] left, int[] right) {
        int i=0,j=0,k=0;
        for(;i<left.length && j<right.length;){
            if (left[i]<right[j]){
                a[k++] = left[i++];
            }else{
                a[k++] = right[j++];
            }
        }
        for(;i<left.length;i++){
            a[k++] = left[i];
        }
        for(;j<right.length;j++){
            a[k++] = right[j];
        }
    }
    //合并两个数组
    private static void merge2(int[]arr,int[]left,int[]right){
        int i=0,j=0,k=0;
        for(;i<left.length&&j<right.length;){
            if(left[i]<right[j]){
                arr[k++] = left[i++];
            }else{
                arr[k++] = right[j++];
            }
        }
        for (;i<left.length;i++){
            arr[k++] = left[i];
        }

        for(;j<right.length;j++){
            arr[k++] = right[j];
        }
    }


    private static int[] setValue2(int[]arr,int start,int length){
        int[] x = new int[length-start];
        for (int i=0;i<x.length;i++){
            x[i] = arr[start++];
        }
        return x;

    }
    private static int[] setValue(int[] a, int start,int length) {
        int[] x = new int[length-start];
        for (int i = 0; i < x.length; i++) {
            x[i] = a[start++];
        }
        return x;
    }


    private static void show(int[] a) {
        System.out.println(Arrays.toString(a));
    }
}
