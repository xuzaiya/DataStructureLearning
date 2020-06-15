package java多线程.入门案例二前后台线程;

public class DemonThread implements Runnable{
    public void run(){
        while (true){
            System.out.println(Thread.currentThread().getName()+"-----is running.");
        }
    }
}
