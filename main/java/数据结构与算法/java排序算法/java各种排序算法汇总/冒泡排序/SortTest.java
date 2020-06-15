package 数据结构与算法.java排序算法.java各种排序算法汇总.冒泡排序;

import java.util.Arrays;
/*
冒泡排序（BubbleSort）就是依次比较相邻的两个数，将小数放在前面，大数放在后面
冒泡排序是计算机的一种排序方法，它的时间复杂度为O（n^2），虽然不及堆排序、快速排序的O（nlogn，底数为2），但是有两个优点：

1.“编程复杂度”很低，很容易写出代码；
2.具有稳定性，这里的稳定性是指原序列中相同元素的相对顺序仍然保持到排序后的序列，而堆排序、快速排序均不具有稳定性。

不过，一路、二路归并排序、不平衡二叉树排序的速度均比冒泡排序快，且具有稳定性，但速度不及堆排序、
快速排序。冒泡排序是经过n-1趟子排序完成的，第i趟子排序从第1个数至第n-i个数，若第i个数比后一个数大
（则升序，小则降序）则交换两数。

冒泡排序算法稳定，O(1)的额外的空间，比较和交换的时间复杂度都是O(n^2)，自适应，对于已基本排序的算法，时间复杂度为O(n)。冒泡算法的许多性质和插入算法相似，但对于系统开销高一点点。
  */
public class SortTest {
    public static void main(String[] args) {
        int[] a = {345,7,32,5,4,-1,3,12,23,110,45645,321,456,78,-1,78,78,32,444,345};
        show(a);
        bubbleSort(a);
        show(a);
    }

    private static void bubbleSort(int[] a) {
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-i-1;j++){
                if(a[j]>a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }
    }

    private static void bubbleSort2(int[]arr){
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-i-1;j++){
                if(arr[j+1]<arr[j]){
                    int temp =  arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    private static void bubbleSort3(int[]arr){
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-i-1;j++){
                if (arr[j+1]<arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    private static void bulbbleSort4(int[]arr){
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-i-1;j++){
                if(arr[j+1]<arr[j]){
                    int temp = arr[j];
                    arr[j]  = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }










    private static void show(int[] a) {
        System.out.println(Arrays.toString(a));
    }








}
