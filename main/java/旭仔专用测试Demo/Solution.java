package 旭仔专用测试Demo;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.Scanner;


public class Solution {
    /**
     * 
     * @param a int整型一维数组 
     * @return double浮点型
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int []arr = new int[n];
        for (int i =0;i<n;i++){
            arr[i] = scan.nextInt();
        }
        System.out.println(solve(arr));

    }

    public static double solve (int[] a) {
        // write code here
        double sqo = 0;
        for(int i = 0 ; i < a.length-3 ; i++){
            for(int j = i+1 ; j <a.length-2 ; j++ ){
                for(int k = j+1 ; k<a.length-1; k++){
                    for(int x = k+1 ; x<a.length ; x++){
                        double sq = 0;
                        if(a[i]>a[j]+a[k]+a[x] ||a[j]>a[i]+a[k]+a[x] ||a[x]>a[j]+a[k]+a[i] ||a[k]>a[j]+a[i]+a[x]){
                            continue;
                        }else{
                            double s = (a[i]+a[j]+a[k]+a[x])/2;
                            sq = (s-a[i])*(s-a[j])*(s-a[k])*(s-a[x]);
                        }
                        if(sq>sqo){
                            sqo =sq;
                        }
                    }
                }
            }
        }
        return (double)Math.sqrt(sqo);
    }

}