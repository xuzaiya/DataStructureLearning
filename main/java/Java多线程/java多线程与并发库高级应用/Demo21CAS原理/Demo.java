package Java多线程.java多线程与并发库高级应用.Demo21CAS原理;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Demo {
    //总访问量
    static int count = 0;
    //模拟访问的方法
    public synchronized  static void request() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(5);
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        //开始时间
        long startTime = System.currentTimeMillis();
        int threadSize =100;

        final CountDownLatch   countDownLatch = new CountDownLatch(threadSize);
        for (int i=0;i<threadSize;i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    //模拟用户行为，每个用户访问10次
                    try{
                        for (int j=0;j<10;j++){
                            request();
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        countDownLatch.countDown();
                    }
                }
            });
            thread.start();
        }
        //怎么保证100个线程结束之后，在执行后面的代码
        countDownLatch.await();
        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+"，耗时："+(endTime-startTime)+", count="+count);
    }
}
