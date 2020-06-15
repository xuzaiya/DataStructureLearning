package java多线程.案例十四两个线程交替输出;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//思路3：ReentrantLock + Condition
public class ThreadTest3 {
    int i = 1;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    boolean firstDone = false;

    public static void main(String[] args) {
        ThreadTest3  t = new ThreadTest3();
        t.print();
    }

    private void print() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(i<=100){
                    lock.lock();
                    if (!firstDone){
                        System.out.println(Thread.currentThread().getName()+"----"+i++);
                        firstDone = true;
                        condition2.signal();
                    }else{
                        try {
                            condition1.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.unlock();
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(i<=100){
                    lock.lock();
                    if(firstDone){
                        System.out.println(Thread.currentThread().getName()+"----"+i++);
                        firstDone = false;
                        condition1.signal();
                    }else{
                        try {
                            condition2.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.unlock();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
