package java设计模式.模式5观察者模式;

import java.util.LinkedList;
import java.util.List;
//创建被观擦者类
public class Subject {
    private List<Observe> observes = new LinkedList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObserves();
    }
    public void attach(Observe observe){
        observes.add(observe);
    }

    private void notifyAllObserves() {
        for (Observe observe: observes){
            observe.update();
        }
    }
}
