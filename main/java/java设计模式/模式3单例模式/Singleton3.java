package java设计模式.模式3单例模式;
/*
* 使用静态内部类实现单例模式
* */
public class Singleton3 {
    private static class SingletonHoler{
        /*
        * 静态初始化器，由jvm保证线程安全
        * */
        private static Singleton3 instance = new Singleton3();
    }
    private Singleton3(){}

    public static Singleton3 getInstance(){
        return SingletonHoler.instance;
    }
}
