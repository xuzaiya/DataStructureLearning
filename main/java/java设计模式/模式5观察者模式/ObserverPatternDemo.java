package java设计模式.模式5观察者模式;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();


        new BinaryObserve(subject);
        new OctalObserve(subject);
        new HexaObserve(subject);

        System.out.println("把状态更改10后");

        subject.setState(10);
    }
}
