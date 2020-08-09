package Java多线程.java多线程与并发库Demo.案例十四两个线程交替输出;

import java.util.concurrent.Semaphore;
//思路2：信号量Semaphore
public class ThreadTest2 {
    int i=1;
    Semaphore s1 = new Semaphore(1);
    Semaphore s2 = new Semaphore(0);

    public static void main(String[] args) {

        ThreadTest2 t = new ThreadTest2();
        t.print();

    }
    public void print(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(i<100){
                    try{
                        s1.acquire();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"----"+i++);
                    s2.release();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(i<=100){
                    try {
                        s2.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"----"+i++);
                    s1.release();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
