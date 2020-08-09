package 数据结构与算法.你要掌握的题型;

/**
 * @author xuzaiya
 * @2020/8/3 15:38
 * 文件说明:有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和。
 * *
*/
public class Demo16 {
    public static void main(String[] args) {
        float fm = 1f;
        float fz = 1f;
        float temp;
        float sum = 0f;
        for (int i=0;i<20;i++){
            temp = fm;
            fm = fz;
            fz = fz + temp;
            sum += fz/fm;
            //System.out.println(sum);
        }
        System.out.println(sum);
    }
}
