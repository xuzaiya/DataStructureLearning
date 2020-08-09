package Java多线程.java多线程与并发库高级应用.Demo7java5并发库线程池技术;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    public static void main(String[] args) {
        //ExecutorService pool = Executors.newFixedThreadPool(3);
        //ExecutorService pool = Executors.newCachedThreadPool();
        ExecutorService pool = Executors.newSingleThreadExecutor();
        for (int i=1;i<=10;i++){
             int task = i;
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j=0;j<10;j++){
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+" is looping of "+j+" for task of "+ task);
                    }
                }
            });
        }

        System.out.println("all of 10 tasks have commited");
        //pool.shutdown();


        Executors.newScheduledThreadPool(3).schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("bombing");
            }
        },10, TimeUnit.SECONDS);  //10秒钟以后执行这个任务


        Executors.newScheduledThreadPool(3).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("bombing");
            }
        },10,2,TimeUnit.SECONDS); //10秒以后执行这个任务，每个两秒执行一次

    }
}
