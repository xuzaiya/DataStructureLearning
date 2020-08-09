package java设计模式.模式3单例模式.price;

/**
 * @author xuzaiya
 * @2020/8/5 8:56
 * 文件说明:自己写一个饿汉式
 */
public class Singleton2 {
    private static Singleton2 singleton = new Singleton2();
    private Singleton2(){}

    public static Singleton2 getInstance(){
        return singleton;
    }
}
