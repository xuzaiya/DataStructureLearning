package 数据结构与算法.java排序算法.java各种排序算法汇总.快速排序;

import java.util.Arrays;
/*
1、算法概念。

快速排序（Quicksort）是对冒泡排序的一种改进。由C. A. R. Hoare在1962年提出。
2、算法思想。

通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。

3、实现思路。

①以第一个关键字 K 1 为控制字，将 [K 1 ,K 2 ,…,K n ] 分成两个子区，使左区所有关键字小于等于 K 1 ，右区所有关键字大于等于 K 1 ，最后控制字居两个子区中间的适当位置。在子区内数据尚处于无序状态。
②把左区作为一个整体，用①的步骤进行处理，右区进行相同的处理。（即递归）
③重复第①、②步，直到左区处理完毕。
  */
//快速排序（无重复值）
public class SortTest {
    public static void main(String[] args) {
        int[] a = {345,7,32,5,4,3,12,23,110};
        show(a);
        quickSort2(a,0,a.length-1);
        show(a);
    }
    private static void quickSort(int[] a, int start, int end) {
        if (start>=end)
            return;
        int i=start;
        int j=end;
        int index = start;
        while(i<j){
            while(a[j]>a[index]){
                j--;
            }
            index = swap(a,j,index);
            while(a[index]>a[i]){
                i++;
            }
            index = swap(a,i,index);
        }
        quickSort(a, start, index-1);
        quickSort(a, index+1, end);
    }



    private static int swap(int[] a, int n, int index) {
        int tmp = a[n];
        a[n] = a[index];
        a[index] = tmp;
        return n;
    }
    private static void show(int[] a) {
        System.out.println(Arrays.toString(a));
    }


    public static void quickSort2(int[]arr,int left ,int right){
        int i,j,t,temp;
        if(left>right){
            return ;
        }
        temp = arr[left];
        i = left;
        j = right;
        while(i!=j){
            while(arr[j]>=temp&&i<j){
                j--;
            }
            while(arr[i]<=temp&&i<j){
                i++;
            }
            if(i<j){
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[left] = arr[i];
        arr[i] = temp;
        quickSort2(arr,left,i-1);
        quickSort2(arr,i+1,right);
    }

    public static void quickSort3(int[]arr,int left,int right){
        int i,j,temp,t;
        if(left>right)return;
        i=left;j=right;temp=arr[left];
        while(i!=j){
            while(arr[j]>=temp&&i<j){j--;}
            while(arr[i]<=temp&&i<j){i++;}
            if(i<j){t=arr[i];arr[i] = arr[j];arr[j] = t;}
        }
        arr[left] = arr[i];arr[i] = temp;
        quickSort3(arr,left,i-1);
        quickSort3(arr,i+1,right);
    }

    public static void quickSort4(int[]arr,int left,int right){
        int i,j,temp,t;
        if(left>right)return ;
        i=left;
        j= right;
        temp = arr[left];
        while(i!=j){
            while(arr[j]>=temp&&i<j){j--;}
            while(arr[i]<=temp&&i<j){i++;}
            if(i<j){
                t=arr[i];arr[i] = arr[j];arr[j] = t;
            }
        }
        arr[left] = arr[i]; arr[i] = temp;
        quickSort4(arr,left,i-1);
        quickSort4(arr,i+1,right);

    }

    public static void quickSort5(int[]arr,int left,int right){
        int i , j,temp,t;
        if(left>right)return;
        i = left;
        j = right;
        temp = arr[left];
        while(i!=j){
            while(arr[j]>=temp&&i<j){j--;}
            while(arr[i]<=temp&&i<j){i++;}
            if(i<j){
                t = arr[i];arr[i] = arr[j];arr[j] = t;
            }
        }
        arr[left] = arr[i];arr[i] = temp;
        quickSort5(arr,left,i-1);
        quickSort5(arr,i+1,right);
    }




    //快速排序
    public static void quickSort7(int[]arr,int left,int right){
        int i,j,temp,t;
        if(left>right)return ;
        i = left;
        j = right;
        temp = arr[left];
        while(i!=j){
            while(arr[j]>=temp&&i<j){j--;}
            while(arr[i]<=temp&&i<j){i++;}
            if(i<j){
                t = arr[i];arr[i] = arr[j];arr[j] = t;
            }
        }
        arr[left] =arr[i];arr[i] = temp;
        quickSort7(arr,left,i-1);
        quickSort7(arr,i+1,right);
    }

    //快速排序
    public static void quicksort8(int[]arr,int left,int right){
        int i,j,temp,t;
        if (left>right)return;
        i = left;
        j = right;
        temp = arr[left];
        while(i!=j){
            while(arr[j]>=temp&&i<j){j--;}
            while(arr[i]<=temp&&i<j){i++;}
            if(i<j){
                t=arr[i];arr[i]=arr[j];arr[j]=t;
            }
        }
        arr[left] = arr[i];arr[i] = temp;
        quickSort7(arr,left,i-1);
        quickSort7(arr,i+1,right);
    }

    //快速排序
    public static void quickSort9(int[]arr,int left,int right){
        int i,j,temp,t;
        if (left>right)return;
        i = left;
        j = right;
        temp = arr[left];
        while(i!=j){
            while(arr[j]>=temp&&i<j){j--;}
            while(arr[i]<=temp&&i<j){i++;}
            if(i<j){
                t=arr[i];arr[i]=arr[j];arr[j] = t;
            }
        }
        arr[left] = arr[i];arr[i] = temp;
        quickSort7(arr,left,i-1);
        quickSort7(arr,i+1,right);
    }

    public static void quickSort10(int[]arr,int left,int right){
        int i ,j,temp,t;
        if (left>right)return ;
        i = left;
        j = right;
        temp = arr[left];
        while(i!=j){
            while(arr[j]>=temp&&i<j){j--;}
            while(arr[i]<=temp&&i<j){i++;}
            if(i<j){
                t=arr[i];arr[i] =arr[j];arr[j] =t;
            }
        }
        arr[left] = arr[i];arr[i] = temp;
        quickSort10(arr,left,i-1);
        quickSort10(arr,i+1,right);

    }

    public static void quickSort11(int[]arr,int left,int right){
        int i ,j,temp,t;
        if (left>right)return ;
        i =left;
        j = right;
        temp = arr[left];
        while(i!=j){
            while(arr[j]>=temp&&i<j){j--;}
            while(arr[i]<=temp&&i<j){i++;}
            if(i<j){
                t=arr[i];arr[i]=arr[j];arr[j]=t;
            }
        }

        arr[left] =arr[i];arr[i] =temp;
        quickSort11(arr,left,i-1);
        quickSort11(arr,i+1,right);

    }
    //快速排序
    public static void quickSort12(int[]arr,int left,int right){
        int i,j,temp,t;
        if (left>right)return ;
        i=left;
        j=right;
        temp = arr[left];
        while(i!=j){
            while(arr[j]>=temp&&i<j){j--;}
            while(arr[i]<=temp&&i<j){i++;}
            if(i<j){
                t=arr[i];arr[i]=arr[j];arr[j]=t;
            }
        }
        arr[left] = arr[i];arr[i]=temp;
        quickSort12(arr,left,i-1);
        quickSort12(arr,i+1,right);
    }


    //快速排序
    public static void quickSort13(int[]arr,int left,int right){
        int i,j,temp,t;
        if(left>right)return ;
        i=left;
        j = right;
        temp = arr[left];
        while(i!=j){
            while(arr[j]>=temp&&i<j){j--;}
            while(arr[i]<=temp&&i<j){i++;}
            if(i<j){
                t=arr[i];arr[i] = arr[j];arr[j] = t;
            }
        }
        arr[left] = arr[i];arr[i] = temp;
        quickSort13(arr,left,i-1);
        quickSort13(arr,i+1,right);
    }

    //快速排序
    public static void quickSort14(int[]arr,int left,int right){
        int i,j,temp,t;
        if (left>right)return;
        i=left;
        j = right;
        temp = arr[left];
        while(i!=j){
            while(arr[j]>=temp&&i<j){j--;}
            while(arr[i]<=temp&&i<j){i++;}
            if (i<j){
                t=arr[i];arr[i] = arr[j];arr[j] = t;
            }
        }
        arr[left] =arr[i];arr[i] = temp;
        quickSort14(arr,left,i-1);
        quickSort14(arr,i+1,right);


    }
















}
