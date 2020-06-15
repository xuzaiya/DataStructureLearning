package java多线程与并发库高级应用.Demo4线程范围内的共享数据;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ThreadShareData {
    private static int data = 0;
    private static Map<Thread,Integer> threadData = new HashMap<>();
    public static void main(String[] args) {
        for (int i=0;i<2;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    data = new Random().nextInt();
                    threadData.put(Thread.currentThread(),data);
                    System.out.println(Thread.currentThread().getName()+" has put data :"+data);
                    new A().get();
                    new B().get();
                    new C().get();
                }
            }).start();
        }


    }

    static class A{
        public void get(){
            int data = threadData.get(Thread.currentThread());
            System.out.println("A from  "+Thread.currentThread().getName()+" get data : "+data);
        }
    }

    static class B{
        public void get(){
            int data = threadData.get(Thread.currentThread());
            System.out.println("B from  "+Thread.currentThread().getName()+" get data : "+data);
        }
    }

    static class C{
        public void get(){
            int data = threadData.get(Thread.currentThread());
            System.out.println("C from  "+Thread.currentThread().getName()+" get data : "+data);
        }
    }
}
