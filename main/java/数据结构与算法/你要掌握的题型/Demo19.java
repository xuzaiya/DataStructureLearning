package 数据结构与算法.你要掌握的题型;

/**
 * @author xuzaiya
 * @2020/8/3 15:38
 * 文件说明:打印出杨辉三角形（要求打印出10行如下图）
 * 1
 * 1   1
 * 1   2   1
 * 1   3   3   1
 * 1   4   6   4   1
 * 1   5   10   10   5   1
 */
public class Demo19 {

    public static void main(String[] args) {
        int i, j;
        int a[][];
        a = new int[8][8];
        for (i = 0; i < 8; i++) {
            a[i][i] = 1;
            a[i][0] = 1;
        }
        for (i = 2; i < 8; i++) {
            for (j = 1; j <= i - 1; j++) {
                a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
            }
        }
        for (i = 0; i < 8; i++) {
            for (j = 0; j < i; j++) {
                System.out.printf("  " + a[i][j]);
            }
            System.out.println();
        }

    }
}
