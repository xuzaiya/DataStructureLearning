package java设计模式.模式1工厂方法模式.多个工厂方法模式;

public class FactoryTest {
    public static void main(String[] args) {

        SendFactory factory = new SendFactory();
        Sender sender = factory.produceSms();
        sender.send();
    }
}
