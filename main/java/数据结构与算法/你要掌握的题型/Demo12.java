package 数据结构与算法.你要掌握的题型;

/**
 * @author xuzaiya
 * @2020/8/3 15:33
 * 文件说明:输出9*9口诀。
 */
public class Demo12 {
    public static void main(String[] args) {
        for(int i=1; i<10; i++) {

            for(int j=1; j<=i; j++) {

                System.out.print(j + "*" + i + "=" + j*i + " " );

            }

            System.out.println();

        }

    }
}
