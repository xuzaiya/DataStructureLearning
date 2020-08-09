package Java多线程.java多线程与并发库Demo.案例十CallableAndFuture;

import java.util.Random;
import java.util.concurrent.*;

public class CallableAndFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<String> future = threadPool.submit(
                new Callable<String>() {
                    public String call() throws InterruptedException {
                        Thread.sleep(2000);
                        return "hello";
                    }
        });

        System.out.println(future.get());

        //提交一组Callable任务
        ExecutorService threadPools = Executors.newFixedThreadPool(10);
        ExecutorCompletionService<Integer> completionService = new ExecutorCompletionService<>(threadPools);
        for (int i=0;i<10;i++){
            final int sqe=i;
            completionService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(new Random().nextInt(5000));
                    return sqe;
                }
            });
        }

        for (int i=0;i<10;i++){
            System.out.println(completionService.take().get());
        }


    }
}
