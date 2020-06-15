package java设计模式.模式6装饰者模式;

public class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Component component){
        super(component);
    }

    public void function(){
        super.function();
        System.out.println("附加功能");
        this.eat();
        this.bellow();
    }
    private void eat(){
        System.out.println("吃肉");
    }
    private void bellow(){
        System.out.println("吼叫");
    }

}
