package 数据结构与算法.java查找算法.java使用二分法进行查找和排序的实例;
/*
实现二分法查找
二分法查找，需要数组内是一个有序的序列
二分查找比线性查找：数组的元素数越多，效率提高的越明显
二分查找的效率表示：O(log2N) N在2的M次幂范围，那查找的次数最大就是M,  log2N表示2的M次幂等于N, 省略常数，简写成O(logN)
如有一个200个元素的有序数组，那么二分查找的最大次数：
2^7=128, 2^8=256, 可以看出7次幂达不到200，8次幂包括， 所以最大查找次数就等于8
  */
public class
SearchTest {


    // 循环 ，二分查找
    public static int binarySearch(int[] array, int data) {
        int start = 0;
        int end = array.length - 1;
        int mid = -1;
        while (start <= end) {
            System.out.println("查找次数");
            mid = (start + end) >>> 1;
            if (array[mid] < data) {
                start = mid + 1;
            } else if (array[mid] > data) {
                end = mid - 1;
            } else {
                return mid;
            }
            System.out.println("start=" + start+",end="+end+",mid="+mid);
        }
        return -1;
    }

    //循环、二分查找
    public static int binarySearch2(int[]arr,int data){
        int start = 0;
        int end = arr.length-1;
        int mid = -1;
        while(start<=end){
            System.out.println("查找次数");
            mid = (start+end)>>>1;
            if (arr[mid]<data){
                start = mid+1;
            }else if(arr[mid]>data){
                end = mid -1;
            }else{
                return mid;
            }

        }
        return -1;
    }






    // 递归二分查找，城市start=0,end = array.length-1
    public static int binarySearch4Recursion(int[] array, int data, int start, int end) {
        int mid = -1;
        System.out.println("查找次数");
        if (start > end) {
            return mid;
        }
        mid = (start + end) >>> 1;
        if (array[mid] < data) {
            return binarySearch4Recursion(array, data, mid + 1, end);
        } else if (array[mid] > data) {
            return binarySearch4Recursion(array, data, start, mid - 1);
        } else {
            return mid;
        }

    }
    public static int binarySearchRecursion(int[]arr,int data,int start,int end){
        int mid  = -1;
        if (start>end){
            return mid;
        }
        mid = (start+end)>>>1;
        if (arr[mid]<data){
            return binarySearchRecursion(arr,data,mid+1,end);
        }else if(arr[mid]>data){
            return binarySearchRecursion(arr,data,start,mid-1);
        }else{
            return mid;
        }
    }



    /*//循环 二分查找
    public static int binarySearch2(int[] array,int data){
        int start = 0;
        int end = array.length -1;
        int mid = -1;
        while(start<=end){
            System.out.println("查找次数");
            mid=(start+end)>>>1;
            if (array[mid]<data){
                start = mid +1;
            }else if(array[mid]>data){
                end = mid-1;
            }else{
                return mid;
            }
            System.out.println("start=" + start+",end="+end+",mid="+mid);
        }
        return -1;
    }

    //递归二分查找，
    public static int binarySearch4Recursion2(int[]array,int data,int start,int end){
        int mid=-1;
        System.out.println("查找次数");
        if (start>end){
            return mid;
        }
        mid = (start+end)>>>1;
        if (array[mid]<data){
            return binarySearch4Recursion2(array,data,mid+1,end);
        }else if(array[mid]>data){
            return binarySearch4Recursion2(array,data,start,mid-1);
        }else{
            return mid;
        }

    }*/



}
