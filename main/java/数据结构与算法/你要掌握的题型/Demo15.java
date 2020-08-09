package 数据结构与算法.你要掌握的题型;

/**
 * @author xuzaiya
 * @2020/8/3 15:38
 * 文件说明:
 * *
 *
 * ***
 *
 * ******
 *
 * ********
 *
 * ******
 *
 * ***
 *
 * *
 *
 * 1.程序分析：先把图形分成两部分来看待，前四行一个规律，后三行一个规律，利用双重   for循环，第一层控制行，第二层控制列。
 */
public class Demo15 {
    public static void main(String[] args) {
        int i=0;
        int j=0;
        for(i=1;i<=4;i++)
        {   for(j=1;j<=2*i-1;j++)
            System.out.print("*");
            System.out.println("");
        }
        for(i=4;i>=1;i--)
        { for(j=1;j<=2*i-3;j++)
            System.out.print("*");
            System.out.println("");
        }
    }
}
