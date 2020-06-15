package 数据结构与算法.java遍历算法.java使用ArrayList遍历及效率比较案例分析;

import java.util.ArrayList;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        ArrayList arrL = new ArrayList();
        ArrayList arrLTmp1 = new ArrayList();
        ArrayList arrLTmp2 = new ArrayList();
        ArrayList arrLTmp3 = new ArrayList();
        ArrayList arrLTmp4 = new ArrayList();

        for (int i=0;i<1000000;i++){
            arrL.add("第"+i+"个");
        }


        long t1 = System.nanoTime();
        //方法1
        Iterator it = arrL.iterator();
        while(it.hasNext()){
            arrLTmp1.add(it.next());
        }


        long t2 = System.nanoTime();
        //方法2
        for(Iterator it2 = arrL.iterator();it2.hasNext();){
            arrLTmp2.add(it2.next());
        }


        long t3 = System.nanoTime();
        //方法3
        for (Object vv:arrL){
            arrLTmp3.add(vv);
        }


        long t4 = System.nanoTime();
        //方法4
        for(int i=0;i< arrL.size();i++){
            arrLTmp4.add(arrL.get(i));
        }
        long t5 = System.nanoTime();
        System.out.println("第一种方法耗时：" + (t2-t1)/1000 + "微秒");
        System.out.println("第二种方法耗时：" + (t3-t2)/1000 + "微秒");
        System.out.println("第三种方法耗时：" + (t4-t3)/1000 + "微秒");
        System.out.println("第四种方法耗时：" + (t5-t4)/1000 + "微秒");
    }
}
