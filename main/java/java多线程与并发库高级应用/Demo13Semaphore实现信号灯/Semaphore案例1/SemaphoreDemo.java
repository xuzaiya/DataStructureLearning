package java多线程与并发库高级应用.Demo13Semaphore实现信号灯.Semaphore案例1;

import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: xuzaiya
 * @Date: 2020/5/22 14:11
 * @Description: # 类的描述
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Storge storge = new Storge();
        for (int i = 0 ;i<12;i++){
            new MyThread(storge).start();
        }

    }
}

class Storge{
    private volatile Boolean[]printer;
    private Semaphore semaphore;
    private Lock lock;
    Storge(){
        semaphore = new Semaphore(3);
        printer = new Boolean[3];
        for (int i = 0 ;i<printer.length;i++){
            printer[i] = true;
        }
        lock = new ReentrantLock();
    }

    public int getFreePrinter(){
        lock.lock();
        try{
            for (int i = 0 ;i<printer.length;i++){
                if (printer[i]){
                    printer[i] =false;
                    return i;
                }
            }

        }finally {
            lock.unlock();
        }
        return -1;

    }

    public void setPrinter(int i){
        lock.lock();
        try {
            printer[i] = true;
        } finally {
            lock.unlock();

        }

    }


    public void print(){
        try {
            //获取信号量
            semaphore.acquire();
            int freePrinter = getFreePrinter();
            System.out.println("Thread " + Thread.currentThread().getName() + " 正在使用"  + freePrinter + "号打印机");
            Thread.sleep(1000);
            setPrinter(freePrinter);
            System.out.println("Thread " + Thread.currentThread().getName() + " 释放"  + freePrinter + "号打印机");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }

    }



}

class  MyThread extends Thread{
    private Storge storge;
    MyThread(Storge storge){
        this.storge = storge;

    }
    public void run(){
        storge.print();
    }

}
