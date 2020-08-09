package Java多线程.java多线程与并发库Demo.入门案例一;

public class Test {
    public static void main(String[] args) {
        TicketWindow tw = new TicketWindow();
        new Thread(tw,"窗口1").start();
        //new Thread(tw,"窗口2").start();
        //new Thread(tw,"窗口3").start();
        //new Thread(tw,"窗口4").start();
    }
}
