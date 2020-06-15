package java多线程与并发库高级应用.Demo21CAS原理;

import java.util.concurrent.atomic.AtomicInteger;

public class ABADemo {
    public static AtomicInteger a = new AtomicInteger(1);

    public static void main(String[] args) {
        Thread main = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("操作线程："+ Thread.currentThread().getName()+",初始值："+a.get());
                try {
                    int exceptNum = a.get();
                    int newNum = exceptNum+1;

                    boolean isCASSuccess = a.compareAndSet(exceptNum,newNum);
                    System.out.println("操作线程"+ Thread.currentThread().getName()+"CAS操作"+isCASSuccess);

                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"主线程");


        Thread other = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(20);//确保Threa-main线程有限执行
                    a.incrementAndGet();
                    System.out.println("操作线程"+Thread.currentThread().getName()+"【increment】,值="+a.get());
                    a.decrementAndGet();
                    System.out.println("操作线程"+Thread.currentThread().getName()+"【decrement】,值="+a.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"干扰线程");

        main.start();
        other.start();


    }
}
