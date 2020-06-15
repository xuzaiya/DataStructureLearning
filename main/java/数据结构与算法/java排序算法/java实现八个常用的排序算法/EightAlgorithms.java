package 数据结构与算法.java排序算法.java实现八个常用的排序算法;
import java.util.Arrays;
/*
   实现了八个常用的排序算法：插入排序、冒泡排序、选择排序、希尔排序
   以及快速排序、归并排序、堆排序和LST基数排序
   @author gkh178
  */
public class EightAlgorithms {

    //插入排序：时间复杂度o(n^2)
    public static void insertSort(int a[], int n) {
        for (int i = 1; i < n; ++i) {
            int temp = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > temp) {
                a[j + 1] =a[j];
                --j;
            }
            a[j + 1] = temp;
        }
    }

    //冒泡排序：时间复杂度o(n^2)
    public static void bubbleSort(int a[], int n) {
        for (int i = n - 1; i > 0; --i) {
            for (int j = 0; j < i; ++j) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    //选择排序：时间复杂度o(n^2)
    public static void selectSort(int a[], int n) {
        for (int i = 0; i < n - 1; ++i) {
            int min = a[i];
            int index = i;
            for (int j = i + 1; j < n; ++j) {
                if (a[j] < min) {
                    min = a[j];
                    index = j;
                }
            }
            a[index] = a[i];
            a[i] = min;
        }
    }

    //希尔排序：时间复杂度介于o(n^2)和o(nlgn)之间
    public static void shellSort(int a[], int n) {
        for (int gap = n / 2; gap >= 1; gap /= 2) {
            for (int i = gap; i < n; ++i) {
                int temp = a[i];
                int j = i -gap;
                while (j >= 0 && a[j] > temp) {
                    a[j + gap] = a[j];
                    j -= gap;
                }
                a[j + gap] = temp;
            }
        }
    }

    //快速排序：时间复杂度o(nlgn)
    public static void quickSort(int a[], int n) {
        _quickSort(a, 0, n-1);
    }
    public static void _quickSort(int a[], int left, int right) {
        if (left < right) {
            int q = _partition(a, left, right);
            _quickSort(a, left, q - 1);
            _quickSort(a, q + 1, right);
        }
    }
    public static int _partition(int a[], int left, int right) {
        int pivot = a[left];
        while (left < right) {
            while (left < right && a[right] >= pivot) {
                --right;
            }
            a[left] = a[right];
            while (left <right && a[left] <= pivot) {
                ++left;
            }
            a[right] = a[left];
        }
        a[left] = pivot;
        return left;
    }

    //归并排序：时间复杂度o(nlgn)
    public static void mergeSort(int a[], int n) {
        _mergeSort(a, 0 , n-1);
    }
    public static void _mergeSort(int a[], int left, int right) {
        if (left <right) {
            int mid = left + (right - left) / 2;
            _mergeSort(a, left, mid);
            _mergeSort(a, mid + 1, right);
            _merge(a, left, mid, right);
        }
    }
    public static void _merge(int a[], int left, int mid, int right) {
        int length = right - left + 1;
        int newA[] = new int[length];
        for (int i = 0, j = left; i <= length - 1; ++i, ++j) {
            newA[i] = a[j];
        }
        int i = 0;
        int j = mid -left + 1;
        int k = left;
        for (; i <= mid - left && j <= length - 1; ++k) {
            if (newA[i] < newA[j]) {
                a[k] = newA[i++];
            }
            else {
                a[k] = newA[j++];
            }
        }
        while (i <= mid - left) {
            a[k++] = newA[i++];
        }
        while (j <= right - left) {
            a[k++] = newA[j++];
        }
    }

    //堆排序：时间复杂度o(nlgn)
    public static void heapSort(int a[], int n) {
        builtMaxHeap(a, n);//建立初始大根堆
        //交换首尾元素，并对交换后排除尾元素的数组进行一次上调整
        for (int i = n - 1; i >= 1; --i) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            upAdjust(a, i);
        }
    }
    //建立一个长度为n的大根堆
    public static void builtMaxHeap(int a[], int n) {
        upAdjust(a, n);
    }
    //对长度为n的数组进行一次上调整
    public static void upAdjust(int a[], int n) {
        //对每个带有子女节点的元素遍历处理，从后到根节点位置
        for (int i = n / 2; i >= 1; --i) {
            adjustNode(a, n, i);
        }
    }
    //调整序号为i的节点的值
    public static void adjustNode(int a[], int n, int i) {
        //节点有左右孩子
        if (2*i + 1 <= n) {
            //右孩子的值大于节点的值，交换它们
            if (a[2*i] > a[i - 1]) {
                int temp = a[2*i];
                a[2 *i] = a[i - 1];
                a[i - 1] = temp;
            }
            //左孩子的值大于节点的值，交换它们
            if (a[2*i -1] > a[i - 1]) {
                int temp = a[2*i - 1];
                a[2 *  i - 1] = a[i - 1];
                a[i - 1] = temp;
            }
            //对节点的左右孩子的根节点进行调整
            adjustNode(a, n, 2  * i);
            adjustNode(a, n, 2  * i + 1);
        }
        //节点只有左孩子，为最后一个有左右孩子的节点
        else if (2 *  i == n) {
            //左孩子的值大于节点的值，交换它们
            if (a[2  * i -1] > a[i - 1]) {
                int temp = a[2 *  i - 1];
                a[2 *  i - 1] = a[i - 1];
                a[i - 1] = temp;
            }
        }
    }

    //基数排序的时间复杂度为o(distance(n+radix)),distance为位数，n为数组个数，radix为基数
    //本方法是用LST方法进行基数排序，MST方法不包含在内
    //其中参数radix为基数，一般为10；distance表示待排序的数组的数字最长的位数；n为数组的长度
    public static void lstRadixSort(int a[], int n, int radix, int distance) {
        int[] newA = new int[n];//用于暂存数组
        int[] count = new int[radix];//用于计数排序，保存的是当前位的值为0 到 radix-1的元素出现的的个数
        int divide = 1;
        //从倒数第一位处理到第一位
        for (int i = 0; i < distance; ++i) {
            System.arraycopy(a, 0, newA, 0, n);//待排数组拷贝到newA数组中
            Arrays.fill(count, 0);//将计数数组置0
            for (int j = 0; j < n; ++j) {
                int radixKey = (newA[j] / divide) % radix; //得到数组元素的当前处理位的值
                count[radixKey]++;
            }
            //此时count[]中每个元素保存的是radixKey位出现的次数
            //计算每个radixKey在数组中的结束位置，位置序号范围为1-n
            for (int j = 1; j < radix; ++j) {
                count[j] = count[j] + count[j - 1];
            }
            //运用计数排序的原理实现一次排序，排序后的数组输出到a[]
            for (int j = n - 1; j >= 0; --j) {
                int radixKey = (newA[j] / divide) % radix;
                a[count[radixKey] - 1] = newA[j];
                --count[radixKey];
            }
            divide = divide  * radix;
        }
    }
}