package Java多线程.java多线程与并发库高级应用.Demo13Semaphore实现信号灯;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
*Semaphore可以维护当前访问自身的线程个数
* 并提供同步机制
* */
public class SemaphoreTest2 {
    public static void main(String[] args) {
        Storage storage = new Storage();
        for (int i =0;i<12;i++){
            new MyThread(storage).start();
        }

    }
}


class Storage{
    private volatile Boolean[]printer;
    private Semaphore semaphore;
    private Lock lock;

    public Storage(){
        semaphore = new Semaphore(3);
        printer = new Boolean[3];
        for(int i=0;i<printer.length;i++){
            printer[i] = false;
        }
        lock = new ReentrantLock();
    }

    public int getFreePrinter(){
        lock.lock();
        try{
            for(int i =0;i<printer.length;i++){
                if(!printer[i]){
                    printer[i] =true;
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
        try{
            printer[i] = false;
        }finally {
            lock.unlock();
        }
    }


    public void print(){
        try{
            //获取信号量
            semaphore.acquire();
            int freePrinter = getFreePrinter();
            System.out.println("Thread " + Thread.currentThread().getName() + " 正在使用"  + freePrinter + "号打印机");
            Thread.sleep(1000);
            setPrinter(freePrinter);
            System.out.println("Thread " + Thread.currentThread().getName() + " 释放"  + freePrinter + "号打印机");

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            semaphore.release();
        }
    }
}

class MyThread extends Thread{
    private Storage storage;
    MyThread(Storage storage){
        this.storage  = storage;
    }
    public void run (){
        storage.print();
    }
}
