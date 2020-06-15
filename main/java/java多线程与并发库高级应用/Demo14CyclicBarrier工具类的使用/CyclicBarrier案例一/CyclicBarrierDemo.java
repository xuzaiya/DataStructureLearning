package java多线程与并发库高级应用.Demo14CyclicBarrier工具类的使用.CyclicBarrier案例一;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Auther: xuzaiya
 * @Date: 2020/5/22 16:02
 * @Description: # 字面意思：回环栅栏 ，通过它可以实现让一组线程等待只某个状态之后在全部同时执行
 */
public class CyclicBarrierDemo {

    public static class TravelTask implements Runnable {
        private CyclicBarrier cyclicBarrier;
        private String name;
        private int arriveTime; //赶到的时间

        public TravelTask(CyclicBarrier cyclicBarrier, String name, int arriveTime) {
            this.cyclicBarrier = cyclicBarrier;
            this.name = name;
            this.arriveTime = arriveTime;
        }

        public void run() {
            try {
                //模拟达到需要花的时间
                Thread.sleep(arriveTime * 1000);
                System.out.println(name + "到达集合点");
                cyclicBarrier.await();
                System.out.println(name + "开始旅行啦～～");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

    }

    public static class TourGuideTask implements Runnable{

        @Override
        public void run() {
            System.out.println("******导游分发护照签证******");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,new TourGuideTask());
        Executor executor = Executors.newFixedThreadPool(3);
        executor.execute(new TravelTask(cyclicBarrier,"哈登",5));
        executor.execute(new TravelTask(cyclicBarrier,"保罗",3));
        executor.execute(new TravelTask(cyclicBarrier,"戈登",1));

    }
}
