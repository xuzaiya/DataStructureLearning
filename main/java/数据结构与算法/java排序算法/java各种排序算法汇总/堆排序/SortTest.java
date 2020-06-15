package 数据结构与算法.java排序算法.java各种排序算法汇总.堆排序;

import java.util.Arrays;
/*
1991年计算机先驱奖获得者、斯坦福大学计算机科学系教授罗伯特·弗洛伊德(Robert W．Floyd)和威廉姆斯(J．Williams)在1964年共同发明了著名的堆排序算法( Heap Sort )。本文主要介绍堆排序用Java来实现。

堆积排序(Heapsort)是指利用堆积树（堆）这种资料结构所设计的一种排序算法，可以利用数组的特点快速定位指定索引的元素。堆排序是不稳定的排序方法，辅助空间为O(1)， 最坏时间复杂度为O(nlog2n) ，堆排序的堆序的平均性能较接近于最坏性能。

堆排序利用了大根堆(或小根堆)堆顶记录的关键字最大(或最小)这一特征，使得在当前无序区中选取最大(或最小)关键字的记录变得简单。

（1）用大根堆排序的基本思想

① 先将初始文件R[1..n]建成一个大根堆,此堆为初始的无序区
② 再将关键字最大的记录R[1](即堆顶)和无序区的最后一个记录R[n]交换，由此得到新的无序区R[1..n-1]和有序区R[n]，且满足R[1..n-1].keys≤R[n].key
③由于交换后新的根R[1]可能违反堆性质，故应将当前无序区R[1..n-1]调整为堆。然后再次将R[1..n-1]中关键字最大的记录R[1]和该区间的最后一个记录R[n-1]交换，由此得到新的无序区R[1..n-2]和有序区R[n-1..n]，且仍满足关系R[1..n-2].keys≤R[n-1..n].keys，同样要将R[1..n-2]调整为堆。
……
直到无序区只有一个元素为止。
（2）大根堆排序算法的基本操作：
① 初始化操作：将R[1..n]构造为初始堆；
② 每一趟排序的基本操作：将当前无序区的堆顶记录R[1]和该区间的最后一个记录交换，然后将新的无序区调整为堆(亦称重建堆)。
注意：
①只需做n-1趟排序，选出较大的n-1个关键字即可以使得文件递增有序。
②用小根堆排序与利用大根堆类似，只不过其排序结果是递减有序的。堆排序和直接选择排序相反：在任何时刻堆排序中无序区总是在有序区之前，且有序区是在原向量的尾部由后往前逐步扩大至整个向量为止。
  */
public class SortTest {
    public static void main(String[] args) {
        int[] a = {345,7,32,5,4,-1,3,12,23,110,45645,321,456,78,-1,78,78,32,444,345};
        show(a);
        heapSort(a);
        show(a);
    }
    //建立最大堆
    private static void headpSort(int[]arr){
        int size = arr.length;
        for (int i=size/2-1;i>=0;i--){
            adjustBigHeap(arr,i,size-1);
        }

        //排序
        for (int j = 0;j<size-1;j++){
            int temp = arr[0];
            arr[0] = arr[size-1-j];
            arr[size-1-j] = temp;
            adjustBigHeap(arr,0,size-2-j);
        }
    }

    
    private static void heapSort(int[] a) {
        //建立最大堆
        int size = a.length;
        for(int i=size/2-1;i>=0;i--){
            adjustBigHeap(a,i,size-1);
        }
        //排序
        for(int j=0;j<size-1;j++){
            int tmp=a[0];
            a[0]=a[size-1-j];
            a[size-1-j]=tmp;
            adjustBigHeap(a,0,size-2-j);
        }
    }


    private static void heapSort2(int[]arr){
        //1.建立大顶堆
        for(int i =arr.length/2-1;i>=0;i--){
            adjustBigHeap(arr,i,arr.length);
        }

        //2.调整堆结构+交换堆顶元素和末尾元素
        for(int j = arr.length-1;j>0;j--){
            swap(arr,0,j); //将堆顶元素与末尾元素进行交换
            adjustBigHeap(arr,0,j);
        }


    }

    private static void heapSort3(int[]arr){
        //1.建立大顶堆
        for (int i=arr.length/2-1;i>=0;i--){
            adjustBigHeap(arr,i,arr.length);
        }

        //2.调整堆结构+交换堆顶元素和末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j); //将堆顶元素与末尾元素进行交换
            adjustBigHeap(arr,0,j);
        }
    }

    //调整堆顶堆
    public static void adjuestHeap3(int[]arr,int i,int length){
        int temp = arr[i];
        for(int k = i*2+1;k<length;k=k*2+1){
            if(k+1<length && arr[k]<arr[k+1]){
                k++;
            }

            if(arr[k]>temp){
                //如果子节点大于父节点，将子节点的值赋值给父节点
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;
    }







    //调整大顶堆
    public static void adjustHeap2(int[]arr,int i ,int length){
        int temp = arr[i]; // 取出当前元素 （非叶子结点）
        for(int k=i*2+1;k<length;k=k*2+1){
            //从i节点的左子节点开始，也就是2i+1开始
            if(k+1<length && arr[k]<arr[k+1]){
                k++;
            }
            if(arr[k]>temp){
                //如果子节点大于父节点，将子节点的值赋值给父节点 不用进行交换
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp ; //将temp值放到最终的位子
    }
    public static void swap(int[]arr,int a,int b){
        int temp  = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }




    //调整大根堆
    private static void adjustBigHeap(int[] a, int start, int end) {
        int tmp = a[start];
        int j = 2 *start+1;
        while(j<=end){
            if (j<end && a[j]<a[j+1]){
                j++;
            }
            if (a[j]>tmp){
                a[start] = a[j];
                start = j;
                j = 2 *j+1;
            }else{
                break;
            }
        }
        a[start] = tmp;
    }

    private static void adjustBigHeap2(int[]arr,int start,int end){
        int temp = arr[start];
        int j = 2*start+1;
        while(j<=end){
            
        }
    }








    private static void show(int[] a) {
        System.out.println(Arrays.toString(a));
    }





}
