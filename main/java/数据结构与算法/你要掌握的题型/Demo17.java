package 数据结构与算法.你要掌握的题型;

/**
 * @author xuzaiya
 * @2020/8/3 15:38
 * 文件说明:求100之内的素数
 * *
 */
public class Demo17 {

    public static void main(String[] args) {
        int sum, i;
        for (sum = 2; sum <= 100; sum++) {
            for (i = 2; i <= sum / 2; i++) {
                if (sum % i == 0)
                    break;
            }
            if (i > sum / 2)
                System.out.println(sum + "是素数");
        }

    }
}
