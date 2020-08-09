package Java多线程.java多线程与并发库高级应用.Demo13Semaphore实现信号灯;

import Java多线程.java多线程与并发库高级应用.Demo13Semaphore实现信号灯.Semapore案例二.SemaphoreDemo;
import com.sun.org.apache.xpath.internal.objects.XString;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
*Semaphore可以维护当前访问自身的线程个数
* 并提供同步机制
* */
public class SemaphoreTest3 {
    public static void main(String[] args) {
        String [] name ={"黎明","王五","王强","赵四","张三","张杰","杨旭"};
        int[]age= {26,27,33,45,19,23,41};
        for (int i =0;i<7;i++){
            Thread t1 = new SemaphoreTest3.InformationThread(name[i],age[i]);
            threadPool.execute(t1);
        }

    }


    private static final Semaphore semaphore = new Semaphore(3);
    private static final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5,10,60, TimeUnit.SECONDS,new LinkedBlockingDeque<>());



    private static class InformationThread extends Thread{
        private final String name;
        private final int age;
        public InformationThread(String name,int age){
            this.name = name;
            this.age = age;
        }

        public void  run(){
            try{
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName()+":大家好，我是"+name+" 我今年的年龄是"+age+"岁"+" 当前时间为： "+System.currentTimeMillis());
                Thread.sleep(1000);
                System.out.println(name + "要准备释放许可证了，当前时间为： "+System.currentTimeMillis());
                System.out.println("当前可使用的许可证数为： "+semaphore.availablePermits());
                semaphore.release();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}

