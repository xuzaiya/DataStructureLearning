package java多线程.案例十一读写锁;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionCommunication {
    public static void main(String[] args) {
        final Business business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<50;i++){
                    business.sub();

                }

            }
        }).start();

        for (int i=0;i<50;i++){
            business.main();
        }

    }

}

class Business{
    Lock lock  = new ReentrantLock();
    Condition condition = lock.newCondition();
    private boolean ShouldSub = true;
    public   void sub()  {
        lock.lock();
        try{
            while (!ShouldSub) {
                try {
                    //this.wait();
                    condition.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            for (int j = 0; j < 10; j++) {
                System.out.println("sub Thread sequence of " + j + " loop of " + j);
            }
            ShouldSub = false;
            //this.notify();
            condition.signal();
        }finally {
            lock.unlock();
        }


    }

    public  void main(){
        lock.lock();
        try{
            while (ShouldSub) {
                try {
                    //this.wait();
                    condition.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            for (int j = 0; j < 100; j++) {
                System.out.println("main Thread sequence of " + j + " loop of " + j);
            }

            ShouldSub=!ShouldSub;
            //this.notify();
            condition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();

        }


    }
}
