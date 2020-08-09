package 数据结构与算法.java排序算法.java各种排序算法汇总.希尔排序;

import java.util.Arrays;
/**
 * 希尔排序也称递减增量排序算法，是插入排序的一种改进版本，
 *先将整个待排元素序列分割成若干个子序列（由相隔某个“增量”的元素组成的）分别进行直接插入排序，
 * 然后依次缩减增量再进行排序，待整个序列中的元素基本有序（增量足够小）时，再对全体元素进行一次直接插入排序
 *
 * 时间复杂度：O(nlog2为底n)或者O(n^1.25)
 * 空间复杂度：由于希尔排序，我们在算法排序过程中，需要一个增量元素，所以空间复杂度为1
 * 稳定性：由于多次插入排序，我们知道一次插入排序是稳定的，不会改变相同元素的相对顺序，但在不同的插入排序过程中，
 * 相同的元素可能在各自的插入排序中移动，最后其稳定性就会被打乱，所以shell排序是不稳定的。
 */




public class shellSort {


    //希尔排序
    public static void shellSort(int[]arr){
        //步长
        for (int gap = arr.length/2;gap>0;gap/=2){
            //start用户指定起始点的下标gap处
            for(int start=gap;start<arr.length;start++){
                int index = start-gap;
                for (;index>=0;index-=gap){
                    //比较大小
                    if (arr[index]>arr[start]){
                        //交换
                        int temp = arr[index+gap];
                        arr[index+gap] = arr[index];
                        arr[index] = temp;
                    }else{
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr= {2,7,4,1,5,3,8,6,9,11,10};
        shellSort3(arr);
        System.out.println(Arrays.toString(arr));
    }




    public static void shellSort2(int[] arr) {
        // 空数组 或 只有一个元素的数组，则什么都不做。
        if (arr == null || arr.length <= 1) return;
        // 定义希尔增量。
        int gap = arr.length / 2;
        // gap缩小到0的时候就退出循环。
        while (gap != 0) {
            // 每组进行直接插入排序。
            for (int i = gap; i < arr.length; i++) {    // i 代表待插入元素的索引。
                int value = arr[i];
                int j = i - gap;    // j 代表i的上一个元素，相差一个增量gap。

                // j < 0 时退出循环，说明 j 是最小的元素的索引值。
                // 或者 arr[j] <= value 时退出循环，说明 j 是比value小的元素的索引值。
                for (; j >= 0 && arr[j] > value; j -= gap) {
                    arr[j + gap] = arr[j];  // 把元素往后挪。
                }
                arr[j + gap] = value;

            }
            // 把每一趟排序的结果也输出一下。
            //print(arr);

            // 缩小增量。
            gap /= 2;
        }
    }


    //希尔排序
    public static void shellSort3(int[]arr){
        if(arr == null || arr.length<=1)return ;
        int gap = arr.length/2;
        while(gap!=0){
            for (int i=gap;i<arr.length;i++){
                int j = i-gap;
                int value= arr[i];
                for (;j>=0&&arr[j]>value;j-=gap){
                    arr[j+gap] = arr[j];

                }
                arr[j+gap] = value;
            }
            gap/=2;
        }
    }

    //希尔排序
    public static void shellSort5(int[]arr){
        if (arr ==  null || arr.length<=1)return ;
        int gap = arr.length/2;
        while(gap!=0){
            for(int i =gap;i<arr.length;i++){
                int j=i-gap;
                int value = arr[i];
                for (;j>=0&&arr[j]>value;j-=gap){
                    arr[j+gap] = arr[j];
                }
                arr[j+gap] = value;
            }
            gap/=2;
        }

    }

    //希尔排序
    public static void shellSort7(int[]arr){
        if (arr == null || arr.length<=1)return;
        int gap = arr.length/2;
        while(gap!=0){
            for (int i=gap;i<arr.length;i++){
                int j=i-gap ;
                int value = arr[i];
                for (;j>=0&&arr[j]>value;j-=gap){
                    arr[j+gap] = arr[j];
                }
                arr[j+gap] = value;
            }
            gap/=2;
        }

    }

    //希尔排序
    public static void shellSort8(int[]arr){
        if (arr == null || arr.length<=1)return;
        int gap = arr.length/2;
        while(gap!=0){
            for (int i=gap;i<arr.length;i++){
                int j = i-gap;
                int value = arr[i];
                for (;j>=0&&arr[j]>value;j-=gap){
                    arr[j+gap] = arr[j];
                }
                arr[j+gap] = value;
            }
            gap/=2;
        }
    }

    //希尔排序
    public static void shellSort9(int[]arr){
        if (arr==null || arr.length<=1)return ;
        int gap = arr.length/2;
        while(gap!=0){
            for (int i=gap;i<arr.length;i++){
                int j = i-gap;
                int value = arr[i];
                for (;j>=0&&arr[j]>value;j-=gap){
                    arr[j+gap] = arr[j];
                }
                arr[j+gap] = value;
            }
            gap/=2;

        }
    }

    //希尔排序
    public static void shellSort10(int[]arr){
        if (arr == null || arr.length<=1)return ;
        int gap = arr.length/2;
        while(gap!=0){
            for (int i = gap ;i<arr.length;i++){
                int j = i-gap;
                int value = arr[i];
                for (;j>=0&&arr[j]>value;j-=gap){
                    arr[j+gap] = arr[j];
                }
                arr[j+gap] = value;
            }
            gap/=2;
        }
    }


    public static void shellSort11(int[]arr){
        if(arr == null || arr.length<=1)return ;
        int gap = arr.length/2;
        while(gap!=0){
            for(int i =gap;i<arr.length;i++){
                int j = i-gap;
                int value = arr[i];
                for(;j>=0&&arr[j]>value;j-=gap){
                    arr[j+gap] = arr[j];
                }
                arr[j+gap]=value;
            }
            gap/=2;
        }

    }


    public static  void shellSort12(int[]arr){
        if(arr== null || arr.length<=1)return ;
        int gap=arr.length/2;
        while(gap!=0){
            for (int i=gap;i<arr.length;i++){
                int j =i-gap;
                int value = arr[i];
                for (;j>=0&&arr[j]>value;j-=gap){
                    arr[j+gap] = arr[j];
                }
                arr[j+gap] = value;
            }
            gap/=2;
        }
    }


   //希尔排序
    public static void shellSort13(int[]arr){
        if(arr == null || arr.length<=1)return;
        int gap=arr.length/2;
        while(gap!=0){
            for (int i=gap;i<arr.length;i++){
                int j = i-gap;
                int value = arr[i];
                for (;j>=0&&arr[j]>value;j-=gap){
                    arr[j+gap] = arr[j];
                }
                arr[j+gap]  = value;
            }
            gap/=2;
        }
    }

    //希尔排序
    public static void shellSort14(int[]arr){
        if (arr ==null || arr.length<=1)return ;
        int gap = arr.length/2;
        while(gap!=0){
            for (int i=gap;i<arr.length;i++){
                int j = i-gap;
                int value = arr[i];
                for (;j>=0&&arr[j]>value;j-=gap){
                    arr[j+gap] = arr[j];
                }
                arr[j+gap] = value;
            }
            gap/=2;
        }
    }



    //希尔排序
    public static void shellSort15(int[]arr){
        if(arr == null || arr.length<=1)return;
        int gap = arr.length/2;
        while(gap!=0){
            for (int i=gap;i<arr.length;i++){
                int j = i-gap;
                int vlaue = arr[i];
                for (;j>=0&&arr[j]>vlaue;j-=gap){
                    arr[j+gap] = arr[j];
                }
                arr[j+gap] = vlaue;
            }
            gap/=2;

        }
    }

    public static void shellSort17(int[]arr){
        if(arr == null || arr.length<=1)return ;
        int gap = arr.length/2;
        while(gap!=0){
            for(int i=gap;i<arr.length;i++){
                int j = i-gap;
                int value = arr[i];
                for(;j>=0&&arr[j]>value;j-=gap){
                    arr[j+gap] = arr[j];
                }
                arr[j+gap] = value;
            }
            gap /=2;
        }

    }

    public static void shellSort18(int[]arr){
        if (arr == null || arr.length<=1)return ;
        int gap = arr.length/2;
        while(gap!=0){
            for (int i=gap;i<arr.length;i++){
                int j = i-gap;
                int value = arr[i];
                for (;j>=0&& arr[j]>value;j-=gap){
                    arr[j+gap] = arr[j];
                }
                arr[j+gap] = value;
            }
            gap/=2;
        }
    }

    public static void shellSort19(int[]arr){
        if(arr == null || arr.length <=1)return;
        int gap = arr.length/2;
        while(gap!=0){
            for(int i=gap;i<arr.length;i++){
                int j = i-gap;
                int value = arr[i];
                for(;j>=0&&arr[j]>value;j-=gap){
                    arr[j+gap] = arr[j];
                }
                arr[j+gap] = value;
            }
            gap/=2;

        }
    }




}
