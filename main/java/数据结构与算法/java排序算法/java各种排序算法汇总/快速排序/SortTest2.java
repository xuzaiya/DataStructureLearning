package 数据结构与算法.java排序算法.java各种排序算法汇总.快速排序;

import java.util.Arrays;

// 快速排序（可含重复值）
public class SortTest2 {
    public static void main(String[] args) {
        int[] a = {345,7,32,5,4,-1,3,12,23,110,45645,321,456,78,-1,78,78,32,345};
        show(a);
        quickSort2(a,0,a.length-1);
        show(a);
    }
    private static void quickSort2(int[] a, int start, int end) {
        if (start>=end)
            return;
        int i=start;
        int j=end;
        int index = end;
        while(i<j){
            while(a[j]>a[index]){
                j--;
            }
            if (j!=index && a[j]==a[index]){
                index = swap(a,--j,index);
            }else{
                index = swap(a,j,index);
            }
            while(a[index]>a[i]){
                i++;
            }
            if (i!=index && a[i]==a[index]){
                index = swap(a,++i,index);
            }else{
                index = swap(a,i,index);
            }
        }
        quickSort2(a, start, index-1);
        quickSort2(a, index+1, end);
    }
    private static int swap(int[] a, int n, int index) {
        int tmp = a[n];
        a[n] = a[index];
        a[index] = tmp;
        return n;
    }
    private static void show(int[] a) {
        System.out.println(Arrays.toString(a));
    }
}
