package 数据结构与算法.你要掌握的题型;

/**
 * @author xuzaiya
 * @2020/8/3 15:31
 * 文件说明:一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？
 *
 * 1.程序分析：在10万以内判断，先将该数加上100后再开方，再将该数加上268后再开方，
 *
 * 如果开方后的结果满足如下条件，即是结果。请看具体分析：
 */
public class Demo10 {
    public static void main(String[] args) {
        for(long l=1L; l<100000; l++) {

            if(Math.sqrt((long)(l+100)) % 1 == 0) {

                if(Math.sqrt((long)(l+268)) % 1 == 0) {

                    System.out.println(l + "加100是一个完全平方数，再加168又是一个完全平方数");

                }

            }

        }
    }

}
