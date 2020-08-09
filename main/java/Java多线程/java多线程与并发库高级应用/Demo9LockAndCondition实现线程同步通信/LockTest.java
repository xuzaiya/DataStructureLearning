package Java多线程.java多线程与并发库高级应用.Demo9LockAndCondition实现线程同步通信;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {
        new LockTest().init();
    }

    private void init() {
        final Outputer outputer = new Outputer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outputer.output("yangxu");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outputer.output("nimad");
                }
            }
        }).start();
    }
}

class Outputer{

    Lock lock = new ReentrantLock();
    public void output(String name) {
        int len = name.length();
        lock.lock();
        try{
            for (int i=0;i<len;i++){
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }finally {
            lock.unlock();
        }


    }


}