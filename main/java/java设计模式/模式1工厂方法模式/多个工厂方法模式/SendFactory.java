package java设计模式.模式1工厂方法模式.多个工厂方法模式;

public class SendFactory {

    public Sender productMail(){
        return new MailSender();
    }


    public Sender produceSms(){
        return new SmsSender();
    }
}
