package java设计模式.模式3适配器模式.Demo2;

/**
 * @author xuzaiya
 * @2020/6/25 15:10
 * 文件说明:实现一个Typec转VGA适配器
 * 适配器实现方式有三种，这是第一种实现方式
 * 通过继承特性来实现适配器功能。
 */
public class Typec2Vga extends Phone implements Vga {

    @Override
    public void vgaInterface() {
        typePhone();
        System.out.println("接收到Type-c口信息，信息转换成VGA接口中...");
        System.out.println("信息已转换成VGA接口，显示屏可以对接。");
    }
}
