package java设计模式.模式2抽象工厂模式;

public class SendSmsFactory  implements  Provider{



    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
