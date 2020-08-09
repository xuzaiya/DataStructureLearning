package 面试中遇到的手撕算法题.入门级算法;

/**
 * @author xuzaiya
 * @2020/7/2 9:29
 * 文件说明:快速排序
 */
public class Demo2 {
    public static void main(String[] args) {
        int[]arr = new int[]{34,2,5,64,23,66,33};
        quickSort(arr,0,arr.length-1);
        for (int i : arr){
            System.out.println(i);
        }
    }
    public static void quickSort(int[]arr,int left,int right){
        int i,j,temp,t;
        if(left>right)return ;
        i =left;
        j = right;
        temp = arr[left];
        while(i!=j){
            while(arr[j]>=temp && i<j){j--;}
            while(arr[i]<=temp && i<j){i++;}
            if(i<j){
                t = arr[i];arr[i] = arr[j] ;arr[j] = t;
            }
        }
        arr[left] = arr[i];arr[i] = temp;
        quickSort(arr,left,i-1);
        quickSort(arr,i+1,right);
    }
}
