package java设计模式.模式3适配器模式;

public class Program {
    //需求：
    //电脑USB ，TypeC

    public static void main(String[] args) {

        Computer computer = new Computer();
        Phone phone = new Phone();


        //电脑通过适配器连接到了手机
        computer.connect(new Adapter(phone));
    }
}
