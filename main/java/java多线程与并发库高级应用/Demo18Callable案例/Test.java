package java多线程与并发库高级应用.Demo18Callable案例;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Auther: xuzaiya
 * @Date: 2020/5/21 16:21
 * @Description: # 类的描述
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(10);
        //创建多个有返回值的任务
        List<Future> list = new ArrayList<>();
        for (int i =0;i<10;i++){
            Callable c  = new MyCallable(i+" ");
            Future f = pool.submit(c);
            list.add(f);
        }
        //关闭线程池
        pool.shutdown();
        //获取所有并发任务的运行结果
        for (Future f: list){
            System.out.println("res: "+f.get().toString());
        }
    }
}
