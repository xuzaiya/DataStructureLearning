package java多线程.案例九线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    public static void main(String[] args) {
        //ExecutorService threadPool = Executors.newFixedThreadPool(3);
        //ExecutorService threadPool = Executors.newCachedThreadPool();// 可以动态的增加线程  缓存线程
        ExecutorService threadPool = Executors.newSingleThreadExecutor();// 可以动态的增加线程   单一线程  线程死了会自动启动



        for (int i=1;i<=10;i++){
            final int task = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j=0;j<10;j++){
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+" is loop of "+j+" for task of " + task);
                    }
                }
            });
        }


        System.out.println("all of 10 tasks have committed");
        //threadPool.shutdown();// 关闭线程池


        Executors.newScheduledThreadPool(3).schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("yangxu");
            }
        },10, TimeUnit.SECONDS);
    }
}
