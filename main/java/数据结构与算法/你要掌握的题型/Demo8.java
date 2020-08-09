package 数据结构与算法.你要掌握的题型;

/**
 * @author xuzaiya
 * @2020/8/3 15:24
 * 文件说明:一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，
 * 求它在 第10次落地时，共经过多少米？第10次反弹多高？
 */
public class Demo8 {
    static double height = 100;

    static double distance = 100;
    public static void main(String[] args) {
        for(int i=1; i<10; i++) {
            distance = distance + height;
            height = height / 2;
        }
        System.out.println("路程：" + distance);
        System.out.println("高度：" + height / 2);


    }
}
