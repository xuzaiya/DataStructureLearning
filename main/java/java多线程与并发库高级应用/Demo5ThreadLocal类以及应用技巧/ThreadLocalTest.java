package java多线程与并发库高级应用.Demo5ThreadLocal类以及应用技巧;



import java.util.HashMap;
import java.util.Map;
import java.util.Random;
/*
* ThreadLocal  就相当于一个map
* 定义个ThreadLocal的变量  往里面存储数据  存储的数据都是当前线程相关的
* */
public class ThreadLocalTest {
    private static ThreadLocal<Integer> x  = new ThreadLocal<>();
    public static void main(String[] args) {
        for (int i=0;i<2;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName()+" has put data :"+data);
                    x.set(data); //当数据存储在当前线程上

                    new A().get();
                    new B().get();
                    new C().get();
                }
            }).start();
        }


    }

    static class A{
        public void get(){
            int data = x.get();
            System.out.println("A from  "+Thread.currentThread().getName()+" get data : "+data);
        }
    }

    static class B{
        public void get(){
            int data = x.get();
            System.out.println("B from  "+Thread.currentThread().getName()+" get data : "+data);
        }
    }

    static class C{
        public void get(){
            int data = x.get();
            System.out.println("C from  "+Thread.currentThread().getName()+" get data : "+data);
        }
    }
}
