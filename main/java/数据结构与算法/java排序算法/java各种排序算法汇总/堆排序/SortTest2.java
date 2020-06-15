package 数据结构与算法.java排序算法.java各种排序算法汇总.堆排序;

import java.util.Arrays;

public class SortTest2 {
    //堆排序
    public static void heapSort(int[] arr){
        //构造大根堆
        heapInsert(arr);//[7, 6, 5, 2, 3, 1, 4]
        //Arrays.stream(arr).forEach(System.out::println);
        int size = arr.length;
        while(size>1){
            swap(arr,0,size-1);
            size--;
            //构造大根堆
            heapify(arr,0,size);
        }

    }

   //堆排序
    public static void heapSort2(int[]arr){
        //构造大根堆
        heapInsert(arr);
        int size = arr.length;
        while(size>1){
            swap(arr,0,size-1);
            size--;
            heapify(arr,0,size);
        }
    }

    //构造大根堆（通过插入新的数据上升）
    public static void heapInsert(int[]arr){
        for(int i=0;i<arr.length;i++){
            //当前插入的索引
            int currentIndex = i;
            int fatherIndex = (currentIndex-1)/2;
            while(arr[currentIndex]>arr[fatherIndex]){
                swap(arr,currentIndex,fatherIndex);
                currentIndex = fatherIndex;
                fatherIndex =(currentIndex-1)/2;
            }
        }
    }

    //构造大根堆 （通过插入新的数据上升）
    public static void heapInsert2(int[]arr){
        for (int i=0;i<arr.length;i++){
            //当前插入索引
            int currentIndex = 1;
            int fatherIndex = (currentIndex-1)/2;
            while(arr[currentIndex]>arr[fatherIndex]){
                swap(arr,currentIndex,fatherIndex);
                currentIndex = fatherIndex;
                fatherIndex = (currentIndex-1)/2;
            }
        }
    }








    //将剩余的数构造成大根堆（通过顶端的数下降）
    public static void heapify(int[] arr,int index,int size){
        int left = 2*index+1;
        int right = 2*index+2;
        while(left<size){
            int largesIndex ;
            //判断孩子中较大的值的索引（要确保右孩子在size范围内）
            if(arr[left]<arr[right] && right<size){
                largesIndex = right;
            }else{
                largesIndex = left;
            }
            //比较父节点的值与孩子中的值，并确定最大 的索引
            if(arr[index]>arr[largesIndex]){
                largesIndex = index;
            }
            //如果父节点索引是最大值索引，那已经是大根堆了，则退出循环
            if (index == largesIndex){
                break;
            }
            //父节点不是最大值，与孩子中较大的交换
            swap(arr,largesIndex,index);
            index = largesIndex;
            //重新计算交换之后的孩子的索引
            left = 2*index+1;
            right = 2*index+2;

        }
    }



    //交换数组中的两个元素的值
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i]  = arr[j];
        arr[j] = temp;
    }

    private static void show(int[] a) {
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        //int[] a = {345,7,32,5,4,-1,3,12,23,110,45645,321,456,78,-1,78,78,32,444,345};
        int [] a = {5,2,7,3,6,1,4};
        show(a);
        //heapSort(a);
        heapInsert(a);
        show(a);
    }

}
