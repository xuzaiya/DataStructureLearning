package java设计模式.模式6装饰者模式;
//具体构建角色
public class ConcreteComponent implements Component {

    @Override
    public void function() {
        System.out.println("基本功能：呼吸+睡觉+觅食");
    }
}
