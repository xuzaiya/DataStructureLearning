package java设计模式.模式1工厂方法模式.普通工厂模式;

public class MailSender implements Sender {

    @Override
    public void send() {
        System.out.println("this is mailsender!");
    }
}
