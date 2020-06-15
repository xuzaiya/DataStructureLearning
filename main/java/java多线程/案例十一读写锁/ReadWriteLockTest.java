package java多线程.案例十一读写锁;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    public static void main(String[] args) {
        Queue queue = new Queue();
        for (int i=0;i<3;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    queue.get();
                }
            }).start();
        }

        for (int i=0;i<3;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    queue.put(Math.random()*1000);
                }
            }).start();
        }


    }
}

class Queue{
    private Object data = null; //共享数据，只能有一个线程能写该数据，但是可以有多个线程同时读该数据
    ReadWriteLock rwl = new ReentrantReadWriteLock();
    public void get(){
        rwl.readLock().lock();

        try{
            System.out.println(Thread.currentThread().getName()+" be ready to read data ");
            Thread.sleep((long)(Math.random()*1000));
            System.out.println(Thread.currentThread().getName()+" have read data: "+ data);
        }catch (InterruptedException e ){
            e.printStackTrace();

        }finally{
            rwl.readLock().unlock();
        }


    }

    public void put(Object data){
        rwl.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+" be ready to write data ");
            Thread.sleep((long)(Math.random()*1000));
            this.data = data;
            System.out.println(Thread.currentThread().getName()+" have write data : "+ data);
        }catch (InterruptedException e){
            e.printStackTrace();

        }finally {
            rwl.writeLock().unlock();
        }


    }
}
