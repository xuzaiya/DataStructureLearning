package java设计模式.模式1工厂方法模式.静态工厂方法模式;

public class SendFactory {

    public static Sender productMail(){
        return new MailSender();
    }


    public  static Sender produceSms(){
        return new SmsSender();
    }
}
