package java设计模式.模式3单例模式.price;



/**
 * @author xuzaiya
 * @2020/8/5 8:42
 * 文件说明:自己默写一个懒汉式
 */
public class Singleton {
    private static Singleton instance = null;

    private Singleton(){}

    //线程安全版本的懒汉式
    public static Singleton getIntence(){
        if (instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance =  new Singleton();
                }
            }
        }
        return instance;

    }


    //线程安全版的懒汉模式
    public static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }


    public static Singleton getInstance2(){
        if (instance == null ){
            instance = new Singleton();
        }
        return instance;
    }


}
