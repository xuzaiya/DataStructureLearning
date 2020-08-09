package 面试中遇到的手撕算法题.入门级算法;

import java.util.Arrays;

/**
 * @author xuzaiya
 * @2020/7/2 9:55
 * 文件说明:归并排序
 */
public class Demo6 {
    public static void main(String[] args) {
        int[] arr = {345,7,32,5,4,-1,3,2,3,5,7,8,90,1,432,1};
        show(arr);
        mergeSor(arr);
        show(arr);
    }
    
    //归并排序
    private static void mergeSor(int[]arr){
        //找出中间值
        int mid = arr.length/2;
        //申请空间存储索引以左的值
        int[] left = setValue(arr,0,mid);
        if(left.length>1){
            mergeSor(left);
        }
        //申请空间存储索引以右的值
        int[] right = setValue(arr,mid,arr.length);
        if(right.length>1){
            mergeSor(right);
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
