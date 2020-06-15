package java设计模式.模式5观察者模式;
/*
* 当对象间存在一对多关系时，则使用观察者模式（Observer Pattern）。
* 比如，当一个对象被修改时，则会自动通知它的依赖对象。
* 注意事项：1、JAVA 中已经有了对观察者模式的支持类。
* 2、避免循环引用。
* 3、如果顺序执行，某一观察者错误会导致系统卡壳，一般采用异步方式。

JAVA语言版观察者模式
* */

//创建观察者的抽象类
public abstract  class Observe {
    protected Subject subject;

    public abstract  void update();
}
