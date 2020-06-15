package 数据结构与算法.java排序算法.java各种排序算法汇总.快速排序.demo;

public class quickSort {
    int a[] = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};

    public quickSort(){
        quick(a);
        for (int i=0;i<a.length;i++){
            System.out.println(i);
        }
    }

    public int getMiddle(int[] list,int low,int high){
        int temp = list[low]; // 数组的第一个作为中轴
        while(low<high){
            while(low<high&&list[high]>=temp){
                high--;
            }

            list[low] = list[high]; // 比中轴小的点移到低端
            while(low<high&&list[low]<=temp){
                low++;
            }
            list[high] = list[low]; // 比中轴大的记录移到高端


        }
        list[low] = temp;
        return low ;

    }



    public void _quickSort(int[]list,int low,int high){
        if (low<high){
            int middle = getMiddle(list,low,high); // 将list数组进行一分为二
            _quickSort(list,low,middle-1); // 对低字表进行递归排序
            _quickSort(list,middle+1,high); // 对高字表进行递归排序
        }

    }


    public void quick(int[]a2){
        if (a2.length>0){ // 查看数组是否为空

            _quickSort(a2,0,a2.length-1);
        }
    }


}
