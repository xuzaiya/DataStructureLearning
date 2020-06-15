package java设计模式.模式6装饰者模式;
//装饰角色
public class Decorator implements Component {
    private Component component;//持有一个Component类型的对象引用

    public Decorator(Component component){
        this.component = component;
    }
    @Override
    public void function() {
        component.function();
    }
}
