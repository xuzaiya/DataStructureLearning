package 数据结构与算法.java排序算法.java各种排序算法汇总.归并排序.链表快速排序;

/**
 * @author xuzaiya
 * @2020/7/30 9:27
 * 文件说明:
 * /*快排：两个指针low和high，枢轴记录的关键字为pivotkey，
 *  * 首先从high所指位置起向前搜索，找到第一个关键字小于pivotkey的记录和枢轴记录交换，
 *  * 然后从low所指位置向后搜索，找到第一个关键字大于pivotkey的记录和枢轴记录交换，
 *  * 重复这两步直到low=high为止*/

public class quickSort {
    public void QuickSort(SqList L){
        QSort(L,0,L.LIST_INIT_SIZE-1);
    }

    public void QSort(SqList L,int low,int high){
        int pivot;
        if(low<high){
            pivot = Partition(L,low,high);
            QSort(L,low,pivot-1);
            QSort(L,pivot+1,high);
        }
    }

    public int Partition(SqList L,int low,int high){
        System.out.println("start low:"+low+",high:"+high);
        int pivotkey;
        pivotkey = (Integer) L.getElement(low);//用子表的第一个记录作枢纽记录
        System.out.println("pivotkey:"+pivotkey);
        while(low<high){//从表的两端交替向中间扫描
            while(low<high && (Integer)L.getElement(high)>=pivotkey)
                high--;
            System.out.println("1-low:"+low+",high:"+high);
            L.swap(L,low,high);//将比枢轴记录小的记录交换到低端
            while(low<high && (Integer)L.getElement(low)<=pivotkey )
                low++;
            System.out.println("2-low:"+low+",high:"+high);
            L.swap(L,low,high);//将比枢轴记录大的记录交换到高端
        }
        System.out.println("low:"+low+",high:"+high);
        return low;//返回枢轴所在位置
    }
    public static void main(String[] args) {
        SqList sqList = new SqList();
        sqList.initList();
        sqList.insertList(49);
        sqList.insertList(38);
        sqList.insertList(65);
        sqList.insertList(97);
        sqList.insertList(76);
        sqList.insertList(13);
        sqList.insertList(27);
        sqList.insertList(49);
        sqList.print();
        quickSort quickSort = new quickSort();
        quickSort.QuickSort(sqList);
        sqList.print();
        System.out.println("第2个元素是："+sqList.getElement(1));
        System.out.println("第4个元素是："+sqList.getElement(3));
    }
}
