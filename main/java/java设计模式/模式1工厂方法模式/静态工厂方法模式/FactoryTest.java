package java设计模式.模式1工厂方法模式.静态工厂方法模式;

public class FactoryTest {
    public static void main(String[] args) {


        Sender sender = SendFactory.productMail();
        sender.send();
    }
}
