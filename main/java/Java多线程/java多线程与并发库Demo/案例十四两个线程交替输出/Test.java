package Java多线程.java多线程与并发库Demo.案例十四两个线程交替输出;


//思路1：synchronized
public class Test {
    int i =1;
    boolean firstDone = false;
    Object lock = new Object();

    public static void main(String[] args) {
        Test  t = new Test();
        t.print();
    }

    private void print() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;i<=100;){
                    synchronized (lock){
                        if (!firstDone){
                            System.out.println(Thread.currentThread().getName()+"----"+i++);
                            firstDone = true;
                            lock.notify();
                        }else{
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;i<=100;){
                    synchronized (lock){
                        if (firstDone){
                            System.out.println(Thread.currentThread().getName()+"----"+i++);
                            firstDone = false;
                            lock.notify();
                        }else{
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
