package java设计模式.模式3单例模式;
/*
* 懒汉式
* */
public class Singleton {
    private static Singleton instance = null;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();

        }
        return instance;
    }

    //改进版 实现线程安全的懒汉式（双重检查加锁）
    public static Singleton getInstance2(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
