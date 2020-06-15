package java设计模式.模式3适配器模式;

public class Adapter implements USB {
    private TypeC device;

    public Adapter(TypeC device){
        this.device = device;
    }

    @Override
    public String getInfo() {
        return this.device.getInfo();
    }
}
