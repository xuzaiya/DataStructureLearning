package 数据结构与算法.java排序算法.java各种排序算法汇总.归并排序.链表快速排序;

/**
 * @author xuzaiya
 * @2020/7/30 9:26
 * 文件说明:
 */
public class SqList {
    public int LIST_INIT_SIZE = 8;//链表的原始大小
    private int INCREMENT = 1;//链表的增量大小
    private Object[] SqList = null;//链表
    private int curIndex = 0;//当前位置
    /**
     * 初始化链表
     * */
    public void initList(){
        SqList = new Object[LIST_INIT_SIZE];
    }

    /**
     * 向链表中插入元素
     * */
    public void insertList(Object o){
        if(curIndex > LIST_INIT_SIZE-1){//判断当前链表是否已经满
            System.out.println("从新分配空间");
            LIST_INIT_SIZE += INCREMENT;
            Object []temp = new Object[LIST_INIT_SIZE];
            for(int i=0; i<curIndex; i++)
            {
                temp[i]=SqList[i];
            }
            SqList = null;
            SqList = temp;
        }
        //链表中如果不让其包含重复元素，则加入这段代码
        /*
        if(isContain(o))
        {
            System.out.println("链表中已包含此元素"+o);
        }else
        {

        }
        */
        SqList[curIndex++] = o;
    }

    /**
     * 判断链表中是否包含某元素
     * */
    private Boolean isContain(Object o){
        for(int i = 0; i<curIndex; i++){
            if(SqList[i].equals(o))
                return true;
        }
        return false;
    }

    /**
     * 删除链表中的某元素
     *
     * 如果包含重复元素都删除
     * */
    public void delete(Object o){
        for(int i = 0; i<curIndex; i++){
            if(SqList[i].equals(o))
            {
                for(int j=i;j<curIndex-1;j++)
                {
                    SqList[j]=SqList[j+1];
                }
                curIndex--;
                continue;
            }
            if(i==curIndex-1)
            {
                System.out.println("不存在此元素"+o);
            }
        }
    }

    /**
     * 获取链表中的某个元素
     * */
    public Object getElement(int i)
    {
        if (i < 0 || i > curIndex)
        {
            System.out.println("获取位置超出了链表中元素个数"+curIndex);
        }
        return SqList[i];
    }

    /**
     * 打印链表
     * */
    public void print()
    {
        for(int i=0;i<curIndex;i++)
        {
            System.out.print(SqList[i]+"\t");
        }
        System.out.println();
    }

    /**
     * 交换链表中的两个元素
     * */
    public void swap(SqList L,int low,int high){
        System.out.println("before swap:low-"+SqList[low]+"  high-"+SqList[high]);
        Object temp = null;
        temp =  SqList[low];
        SqList[low] = SqList[high];
        SqList[high] = temp;
        System.out.println("after swap:low-"+SqList[low]+"  high-"+SqList[high]);
    }
}

