package 面试中遇到的手撕算法题.入门级算法;

/**
 * @author xuzaiya
 * @2020/7/2 9:55
 * 文件说明:单例模式
 * 饿汉式
 *
 */
public class Demo9 {
    public static Demo9 demo9 = new Demo9();
    private Demo9() {
    }
    public static Demo9 getInstance(){
        return demo9;
    }
}
