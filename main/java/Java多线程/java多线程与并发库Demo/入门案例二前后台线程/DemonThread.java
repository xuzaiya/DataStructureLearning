package Java多线程.java多线程与并发库Demo.入门案例二前后台线程;

public class DemonThread implements Runnable{
    public void run(){
        while (true){
            System.out.println(Thread.currentThread().getName()+"-----is running.");
        }
    }
}
