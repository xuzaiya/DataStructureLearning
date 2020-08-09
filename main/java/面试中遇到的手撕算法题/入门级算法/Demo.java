package 面试中遇到的手撕算法题.入门级算法;

/**
 * @author xuzaiya
 * @2020/7/2 9:25
 * 文件说明: 冒泡排序
 */
public class Demo {
    public static void main(String[] args) {
        int[]arr = new int[]{34,2,5,64,23,66,33};
        bubbleSort(arr);
        for (int i : arr){
            System.out.println(i);
        }
    }

    public static void bubbleSort(int[]arr){
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-i-1;j++){
                if(arr[j+1]<arr[j]){
                    int temp  = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
