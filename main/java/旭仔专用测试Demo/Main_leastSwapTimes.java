package 旭仔专用测试Demo;

import java.util.*;
public class Main_leastSwapTimes
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = scan.nextInt();
        }

        int times = function(arr, 0, arr.length-1);
        System.out.print(times);
     
    }
    public static int function(int[] arr, int left, int right) 
    {
        if(left == right) 
        {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int i = left;
        int j = -1;//最大值所在的索引
        while(i <= right) 
        {
            if(arr[i] > max) 
            {
                max = arr[i];
                j = i;
            }
            i++;
        }
        if(max == arr[right]) 
        {
            return function(arr,left,right-1);
        }
        else 
        {
            swap(arr,j,right);
            return 1+function(arr,left,right-1);
        }
    }
    public static void swap(int[] arr,int i,int j) 
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
   
}