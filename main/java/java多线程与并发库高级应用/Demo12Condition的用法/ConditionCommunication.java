package java多线程与并发库高级应用.Demo12Condition的用法;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 子线程循环10次，接着主线程循环100次，接着又回到子线程循环10次，接着
 * 再回到主线程循环100次，如此循环50次
 * */
public class ConditionCommunication {
    public static void main(String[] args) {
            Business business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 50; i++) {
                    business.subThread(i);
                }
            }
        }).start();

        for (int i = 1; i <= 50; i++) {
            business.mainThread(i);
        }


    }
}


class Business {

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    private boolean bShouldSub = true;

    // if 可以换成  while  效果更健壮
    public  void subThread(int j) {
        lock.lock();
        try {
            while (!bShouldSub) {
                try {
                    //this.wait();
                    condition.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println("sub Thread sequene of " + i + " loop of " + j);
            }
            bShouldSub = false;
            //this.notify();
            condition.signal();
        }finally {
            lock.unlock();
        }


    }


    public  void mainThread(int j) {
        lock.lock();
        try {
            while (bShouldSub) {
                try {
                    //this.wait();
                    condition.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            for (int i = 1; i <= 100; i++) {
                System.out.println("main Thread sequene of " + i + " loop of " + j);
            }
            bShouldSub = true;
            //this.notify();
            condition.signal();
        }finally {
            lock.unlock();
        }

    }
}
