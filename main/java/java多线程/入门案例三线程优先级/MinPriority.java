package java多线程.入门案例三线程优先级;

public class MinPriority implements Runnable{
    public void run(){
        for (int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"正在输出："+i);
        }
    }
}
