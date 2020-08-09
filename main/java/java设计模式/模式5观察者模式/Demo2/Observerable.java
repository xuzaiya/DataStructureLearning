package java设计模式.模式5观察者模式.Demo2;


/**
 * @author xuzaiya
 * @2020/6/25 14:38
 * 文件说明： 抽象被观察者接口
 * 声明了添加、删除、通知观察者方法
 */
public interface  Observerable {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();

}
