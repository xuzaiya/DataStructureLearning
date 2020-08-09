package Java多线程.java多线程与并发库高级应用.Demo8CallableAndFuture的用法;

import java.util.Random;
import java.util.concurrent.*;

public class CallableAndFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {




        ExecutorService threadpool = Executors.newFixedThreadPool(1);

        Future<String> future = threadpool.submit(new Callable<String>() {
            public String call() throws InterruptedException {
                Thread.sleep(2000);
                return "hello";
            }
        });
        System.out.println("等待结果");
        System.out.println("拿到结果："+future.get());



        /*
        * CompletionService用于提交一组Callable任务，其take方法返回已完成的一个Callable任务对应的Future对象
        * */
        ExecutorService threadpool2 = Executors.newFixedThreadPool(10);
        CompletionService<Integer> service = new ExecutorCompletionService<>(threadpool2);
        for (int i=1;i<=10;i++){
            final int sql = i;
            service.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(new Random().nextInt(5000));
                    return sql;
                }
            });
        }

        for (int i=0;i<10;i++){
            System.out.println(service.take().get());
        }

    }
}
