package 数据结构与算法.你要掌握的题型;

/**
 * @author xuzaiya
 * @2020/8/1 19:12
 * 文件说明: 排列计算
 * 古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
 * 兔子的规律为数列1,1,2,3,5,8,13,21....
 */
public class demo {
    public static final int MONTH = 15;
    public static void main(String[] args) {
        long f1 = 1L, f2 = 1L;

        long f;

        for(int i=3; i<MONTH; i++) {

            f = f2;

            f2 = f1 + f2;

            f1 = f;

            System.out.print("第" + i + "个月的兔子对数: ");

            System.out.println(" " + f2);
        }
    }
}
