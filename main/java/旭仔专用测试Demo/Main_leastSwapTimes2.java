package 旭仔专用测试Demo;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main_leastSwapTimes2
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[]arr = new int[n];
        for(int i = 0 ;i<n;i++){
            arr[i] = scan.nextInt();
        }

        int[] arr2 = new int[n];
        for(int i =0;i<n;i++){
            arr2[i] = i+1;
        }


    }

   
}


