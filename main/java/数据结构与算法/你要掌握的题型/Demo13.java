package 数据结构与算法.你要掌握的题型;

/**
 * @author xuzaiya
 * @2020/8/3 15:35
 * 文件说明:
 * 猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，
 *
 * //又多吃了一个 第二天早上又将剩下的桃子吃掉一半，又多吃了一个。
 *
 * //以后每天早上都吃了前一天剩下 的一半零一个。到第10天早上想再吃时，
 *
 * //见只剩下一个桃子了。求第一天共摘了多少。
 *
 * //1.程序分析：采取逆向思维的方法，从后往前推断。
 */
public class Demo13 {

    public static void main(String[] args) {
        int lastdayNum = 1;

        for(int i=2; i<=10; i++) {

            lastdayNum = (lastdayNum+1) * 2;

        }

        System.out.println("猴子第一天摘了 " + lastdayNum + " 个桃子");
    }
}
