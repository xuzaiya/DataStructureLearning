package java设计模式.模式5观察者模式;



public class BinaryObserve extends Observe {
    @Override
    public void update() {
        System.out.println("BinaryObserve观察到的物体状态更新为："+subject.getState());
    }

    public BinaryObserve(Subject subject){
        this.subject = subject;
        subject.attach(this);
    }
}
