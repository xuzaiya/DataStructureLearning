package java设计模式.模式5观察者模式.Demo2;

/**
 * @author xuzaiya
 * @2020/6/25 14:41
 * 文件说明:抽象观察者
 * 定义了一个update（）方法，当被观察者调用notifyObservers()方法时，观察者的updatae方法被回调
 */
public interface Observer {
    public void update(String message);
}
