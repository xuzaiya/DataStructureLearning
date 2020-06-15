package java设计模式.模式3单例模式;
/*
* 饿汉式
* 饿汉式是典型的空间换时间，当类装载的时候就会创建类实例，不管你用不用，
* 先创建出来，然后每次调用的时候，就不需要判断了，节省了运行时间。
* */
public class Singleton2 {
    private static Singleton2 instance = new Singleton2();
    //私有化构造函数
    private Singleton2(){}

    public static Singleton2 getInstance(){
        return instance;
    }
}
