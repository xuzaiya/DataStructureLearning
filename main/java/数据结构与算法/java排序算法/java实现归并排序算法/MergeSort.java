package 数据结构与算法.java排序算法.java实现归并排序算法;

public class MergeSort {



    public static void MergeSorts(int[] array,int head,int tail){
        // 判断数组的头部索引是否小于尾部索引
        if(head < tail){
            int middle = (head+tail)/2;
            MergeSorts(array,head,middle);
            MergeSorts(array,middle+1,tail);
            Merge(array,head,middle,tail);
        }
    }


    public static void Merge(int[] array, int head, int middle, int tail) {
        // TODO Auto-generated method stub
        int[] temp = new int[tail - head + 1];
        int a = head;
        int b = middle + 1;
        int i = 0;
        // 对于两个数组中的数进行比较，将较小的值存放在临时数组中
        while(a <= middle && b <=tail){

            if(array[a] < array[b]){
                temp[i++] = array[a++];
            }
            else{
                temp[i++] = array[b++];
            }
        }

        // 将未参与比较的数组中的数添加到临时数组中
        while(a <= middle){
            temp[i++] = array[a++];
        }

        while(b <= tail){
            temp[i++] = array[b++];
        }

        // 将排好序的数组放回到array数组中
        System.arraycopy(temp,0,array,head,tail - head + 1);
    }

}
