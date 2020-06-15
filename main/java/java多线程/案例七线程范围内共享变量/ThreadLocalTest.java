package java多线程.案例七线程范围内共享变量;


import java.util.Random;

public class ThreadLocalTest {

    private static ThreadLocal<Integer> x = new ThreadLocal<>();
    private  static ThreadLocal<MyThreadScopeData> myThreadScopeData = new ThreadLocal<>();
    public static void main(String[] args) {
        for (int i=0;i<2;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName()+" havs put data :"+data);
                    x.set(data);
                   /* MyThreadScopeData myThreadScopeData = new MyThreadScopeData();
                    myThreadScopeData.setAge(data);
                    myThreadScopeData.setName("name"+data);
                    myThreadScopeDataThreadLocal.set(myThreadScopeData);*/

                   MyThreadScopeData.getInstance().setName("name"+data);
                   MyThreadScopeData.getInstance().setAge(data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }

    }


    static class A{
        public void get(){
            int data = x.get();
            MyThreadScopeData mydata = myThreadScopeData.get();
            System.out.println("A from "+Thread.currentThread().getName()+"get data: "+data);
            System.out.println("A from "+Thread.currentThread().getName()+"get data: "+mydata.getName()+mydata.getAge());

        }
    }

    static class B{
        public void get(){
            int data = x.get();
            MyThreadScopeData mydata = myThreadScopeData.get();
            System.out.println("B from "+Thread.currentThread().getName()+"get data: "+data);
            System.out.println("B from "+Thread.currentThread().getName()+"get data: "+mydata.getName()+mydata.getAge());
        }
    }


}


class MyThreadScopeData{

    /*
    private MyThreadScopeData();
    private MyThreadScopeData getInstance(){
        return instance;
    }
    private static MyThreadScopeData instance = new MyThreadScopeData();*/

    //饿汉模式
    /*private static MyThreadScopeData instance=null;
    public  static synchronized MyThreadScopeData getInstance(){
        if(instance == null){
            instance = new MyThreadScopeData();
        }
        return instance;
    }*/

    private MyThreadScopeData(){};
    public static  MyThreadScopeData getInstance(){
        MyThreadScopeData instance = map.get();
        if (instance == null){
            instance = new MyThreadScopeData();
            map.set(instance);
        }
        return instance;
    }
    private static ThreadLocal<MyThreadScopeData> map = new ThreadLocal<>();

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


