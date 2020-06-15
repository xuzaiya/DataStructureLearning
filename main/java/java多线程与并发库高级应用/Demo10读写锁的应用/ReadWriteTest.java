package java多线程与并发库高级应用.Demo10读写锁的应用;


import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteTest {

    public static void main(String[] args) {
        final Queue3 q3 = new Queue3();
        for (int i=0;i<3;i++){
            new Thread(){
                public void run(){
                    while (true){
                        q3.get();
                    }
                }
            }.start();

            new Thread(){
                public void run(){
                    while (true){
                        q3.put(new Random().nextInt(100000));
                    }
                }
            }.start();
        }

    }
}

class Queue3{
    private Object data = null;
    ReadWriteLock rwl = new ReentrantReadWriteLock();
    public void get(){
        rwl.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+" be ready to read data");
            Thread.sleep((long)(Math.random()*1000));
            System.out.println(Thread.currentThread().getName()+" have read data: "+ data);
        }catch (Exception e){
            e.printStackTrace();
        }finally {

            rwl.readLock().unlock();
        }
    }

    public void put(Object data){
        rwl.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+" be ready to write data");
            Thread.sleep((long)(Math.random()*1000));
            System.out.println(Thread.currentThread().getName()+" have write data: "+data);
            this.data = data;
        }catch (Exception e){
            e.printStackTrace();
        }finally {

            rwl.writeLock().unlock();
        }
    }
}
