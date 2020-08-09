package Java多线程.java多线程与并发库Demo.入门案例三线程优先级;

public class MaxPriority implements Runnable {
    public void run(){
        for (int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"正在输出："+i);
        }
    }
}
