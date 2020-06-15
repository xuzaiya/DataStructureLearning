package java设计模式.模式1工厂方法模式.普通工厂模式;

public class FactoryTest {
    public static void main(String[] args) {

        SendFactory factory = new SendFactory();
        Sender sender = factory.produce("mail");
        sender.send();
    }
}
