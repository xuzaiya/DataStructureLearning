package java设计模式.模式3适配器模式;

public class Phone implements TypeC{


    @Override
    public String getInfo() {

        return "这是一个手机";
    }
}
