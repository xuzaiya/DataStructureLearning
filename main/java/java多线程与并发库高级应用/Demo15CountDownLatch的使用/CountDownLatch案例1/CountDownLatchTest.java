package java多线程与并发库高级应用.Demo15CountDownLatch的使用.CountDownLatch案例1;


import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/**
 * @Auther: xuzaiya
 * @Date: 2020/5/22 15:35
 * @Description: # CountDownLatch ：在多线程并发编程中充当一个计时器功能，
 * 使用场景：当需要等待某个条件到要求后才能做后面的事情，同时当线程都完成了才能出发后面的的事情
 */
public class CountDownLatchTest {
    private final static CountDownLatch cdl = new CountDownLatch(3);
    private final static Vector v = new Vector();

    private static  class WriteThread extends Thread{
        private final String writeThreadName;
        private final int stopTime;
        private final String str;
        public WriteThread(String name,int time,String str){
            this.writeThreadName =   name;
            this.stopTime = time;
            this.str = str;
        }
        public void run(){
            System.out.println(writeThreadName+"开始写入工作");
            try {
                Thread.sleep(stopTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cdl.countDown();
            v.add(str);
            System.out.println(writeThreadName+"写入内容为："+str+".写入工作结束");

        }
    }

    private static class ReadThread extends Thread{
        public void run(){
            System.out.println("读操作之前必须先进行写操作");
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i =0;i<v.size();i++){
                System.out.println("读取第"+(i+1)+"条记录内容为："+v.get(i));
            }
            System.out.println("读操作结束！");
        }
    }
    public static void main(String[] args) {
        new ReadThread().start();
        new WriteThread("writeThread1",1000,"多线程知识点").start();
        new WriteThread("writeThread2",2000,"多线程CountDownLatch的知识点").start();
        new WriteThread("writeThread3",3000,"多线程中控制顺序可以使用CountDownLatch").start();

    }
}
