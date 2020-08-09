package Java多线程.java多线程与并发库高级应用.Demo14CyclicBarrier工具类的使用;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
* CyclicBarrier表示大家彼此等待，大家集合好后才开始出发
*
* */
public class CyclicBarrierTest2 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        final CyclicBarrier cb = new CyclicBarrier(3);
        for (int i = 0 ; i< 3;i++){
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try{
                        Thread.sleep((long)(Math.random()*1000));
                        System.out.println("线程"+Thread.currentThread().getName()+
                                "即将到大集合地点1，当前已有"+(cb.getNumberWaiting()+1)+"个已经到达，正在等候");
                        cb.await();
                        System.out.println("线程"+Thread.currentThread().getName()+
                                "即将到大集合地点2，当前已有"+(cb.getNumberWaiting()+1)+"个已经到达，正在等候");
                        cb.await();
                        Thread.sleep((long)(Math.random()*10000));
                        System.out.println("线程"+Thread.currentThread().getName()+
                                "即将到大集合地点3，当前已有"+(cb.getNumberWaiting()+1)+"个已经到达，正在等候");
                        cb.await();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            };
            service.execute(runnable);
        }


    }
}
