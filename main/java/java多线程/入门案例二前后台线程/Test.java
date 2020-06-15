package java多线程.入门案例二前后台线程;

public class Test {
    public static void main(String[] args) {
        System.out.println("main线程是后台线程？"+Thread.currentThread().isDaemon()); //false
        DemonThread dt = new DemonThread();
        Thread t = new Thread(dt,"后台线程");
        t.setDaemon(true); //t线程启动之前设置为后台线程
        t.start();
        for (int i=0;i<10;i++){
            System.out.println(i);
        }
    }
}
