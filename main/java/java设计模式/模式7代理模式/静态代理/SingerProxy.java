package java设计模式.模式7代理模式.静态代理;

public class SingerProxy implements ISinger {

    //接收目标对象，以便调用sing方法
    private ISinger target;
    public SingerProxy(ISinger target){
        this.target = target;
    }

    //对目标对象的sing方法进行扩展
    @Override
    public void sing() {
        System.out.println("向观众问好");
        target.sing();
        System.out.println("谢谢大家");
    }
}
