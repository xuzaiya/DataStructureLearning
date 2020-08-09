package Java多线程.java多线程与并发库Demo.案例十三CycliBarrier类;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CycliBarrierTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        for (int i=0;i<3;i++){
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try{
                        Thread.sleep((long)(Math.random()*1000));
                        System.out.println("线程"+Thread.currentThread().getName()+"即将到达集合地点，当前已有"+(cyclicBarrier.getNumberWaiting()+1));
                        cyclicBarrier.await();
                        Thread.sleep((long)(Math.random()*1000));
                        System.out.println("线程"+Thread.currentThread().getName()+"即将到达集合地点，当前已有"+(cyclicBarrier.getNumberWaiting()+1));

                        cyclicBarrier.await();
                        Thread.sleep((long)(Math.random()*1000));
                        System.out.println("线程"+Thread.currentThread().getName()+"即将到达集合地点，当前已有"+(cyclicBarrier.getNumberWaiting()+1));

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            };
            service.execute(runnable);
        }
        service.shutdown();
    }
}
