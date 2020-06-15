package java多线程与并发库高级应用.Demo15CountDownLatch的使用;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
* 犹如倒计时计数器，调用CountDownLatch的countDown方法就将计数器减1，当计数到达0时
* 则所有等待着开始执行任务
*
* */
public class CountDownLatch {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        //CountDownLatch cdOrder = new CountDownLatch(1);
        //CountDownLatch cdAnswer = new CountDownLatch(3);
        for(int i=0;i<3;i++){
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    /*try {
                        System.out.println("线程"+Thread.currentThread().getName()+"正在接受命令");
                        cdOrder.await();
                        System.out.println("线程"+Thread.currentThread().getName()+"已接受命令");
                    }catch (Exception e){
                        e.printStackTrace();
                    }*/
                }
            };
        }
    }
}
