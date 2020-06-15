package java设计模式.模式3适配器模式;

public class Computer {

    private USB usb;

    public void connect(USB usbDevice){
        this.usb = usbDevice;
    }

    public void showInfo(){
        System.out.println(this.usb.getInfo());
    }


}
