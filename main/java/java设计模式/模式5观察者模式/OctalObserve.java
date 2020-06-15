package java设计模式.模式5观察者模式;

public class OctalObserve extends Observe {
    @Override
    public void update() {
        System.out.println("OctalObserve观察到的物体状态更新为："+subject.getState());
    }

    public OctalObserve(Subject subject){
        this.subject = subject;
        subject.attach(this);
    }
}
