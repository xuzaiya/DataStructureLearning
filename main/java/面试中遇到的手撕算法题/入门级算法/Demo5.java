package 面试中遇到的手撕算法题.入门级算法;

/**
 * @author xuzaiya
 * @2020/7/2 9:55
 * 文件说明:二分查找
 *
 */
public class Demo5 {
    public static void main(String[] args) {
        int[]arr =new int[]{3,5,65,2,12,33,74,9};
        int value = binSearch(arr,3);
        System.out.println(value);
    }



    //循环二分查找
    public static int binSearch(int arr[],int key){
        int mid = arr.length/2;
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            mid = (end-start)/2+start;
            if (key == arr[mid]){
                return mid;
            }else if(key <arr[mid]){
                end = mid -1;
            }else if(key>arr[mid]){
                start = mid+1;
            }
        }
        return -1;
    }


}
