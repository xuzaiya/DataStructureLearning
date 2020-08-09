package 面试中遇到的手撕算法题.入门级算法.最大公约数;

/**
 * @author xuzaiya
 * @2020/7/2 9:25
 * 文件说明: 最大公约数
 */
public class Demo {
    public static void main(String[] args) {
        int num = gcd(4,8);
        System.out.println(num);
    }


    public static int gcd(int num1, int num2) {
        // 先获得绝对值，保证负数也可以求
        num1 = Math.abs(num1);
        num2 = Math.abs(num2);
        // 假定第一个数较大；如果第二个较大，在第二轮会颠倒过来
        // 如果第二个数为 0，则第一个数就是最大公约数
        while (num2 != 0) {
            // 求余
            int remainder = num1 % num2;
            // 交换数，等同递归调用
            num1 = num2;
            num2 = remainder;
        }

        return num1;
    }


}
