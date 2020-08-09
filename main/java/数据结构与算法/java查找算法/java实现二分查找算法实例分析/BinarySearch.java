package 数据结构与算法.java查找算法.java实现二分查找算法实例分析;

public class BinarySearch {
    public static void main(String[] args) {
        int searchArr[] = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            searchArr[i] = i;
        }
        System.out.println(binSearch(searchArr, 0, searchArr.length - 1, 99));
        System.out.println(binSearch3(searchArr, 99));
    }

    //递归二分查找
    public static int binSearch(int arr[], int start, int end, int sear) {
        int mid = (end - start) / 2 + start;
        if (sear == arr[mid]) {
            return mid;
        }
        if (start >= end) {
            return -1;
        } else if (sear < arr[mid]) {
            return binSearch(arr, 0, mid - 1, sear);
        } else if (sear > arr[mid]) {
            return binSearch(arr, mid + 1, end, sear);
        }
        return -1;
    }

    //递归二分查找
    public static int binSearch3(int[]arr,int start,int end,int sear){
        int mid = (end-start)/2+start;
        if(sear == arr[mid]){
            return mid;
        }
        if(start>=end){
            return -1;
        }else if(sear<arr[mid]){
            return binSearch2(arr,start,mid-1,sear);
        }else if(sear>arr[mid]){
            return binSearch2(arr,mid+1,end,sear);
        }
        return -1;
    }

    /*//循环二分查找
    public static int binSearch(int arr[], int key) {
        int mid = arr.length / 2;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            mid = (end - start) / 2 + start;
            if (key == arr[mid]) {
                return mid;
            } else if (key <= arr[mid]) {
                end = mid - 1;
            } else if (key >= arr[mid]) {
                start = mid + 1;
            }
        }
        return -1;
    }*/


    //递归二分查找法
    public static int binSearch2(int arr[],int start ,int end ,int sear){
        int mid = (end-start)/2+start;
        if(sear == arr[mid]){
            return mid;
        }
        if (start>=end){
            return -1;
        }else if(sear<arr[mid]){
            return binSearch2(arr,0,mid-1,sear);
        }else if(sear>arr[mid]){
            return binSearch2(arr,mid+1,end,sear);
        }
        return -1;

    }

    //循环二分查找
    public static int binSearch3(int arr[],int key){
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


    public static int binSearch4(int[]arr,int key){
        int mid =arr.length/2;
        int start = 0 ;
        int end = arr.length-1;
        while(start<=end){
            mid = (end-start)/2+start;
            if(key == arr[mid]){
                return mid;
            }else if(key<arr[mid]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }


    public static int binSearch5(int[]arr,int key){
        int mid = arr.length/2;
        int start  = 0 ;
        int end = arr.length-1;
        while(start<=end){
            mid = (end-start)/2+start;
            if(key == arr[mid]){
                return mid;

            }else if(key<arr[mid]) {
                end = mid - 1;
            }else{
                start = mid +1;
            }
        }
        return  -1;
    }
}
