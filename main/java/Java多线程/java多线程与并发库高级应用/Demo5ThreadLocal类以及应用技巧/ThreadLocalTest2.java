package Java多线程.java多线程与并发库高级应用.Demo5ThreadLocal类以及应用技巧;



import java.util.Random;

/*
* ThreadLocal  就相当于一个map
* 定义个ThreadLocal的变量  往里面存储数据  存储的数据都是当前线程相关的
* */
public class ThreadLocalTest2 {
    private static ThreadLocal<Integer> x  = new ThreadLocal<>();
    private static ThreadLocal<MyThreadScopeData> myThreadScopeDataThreadLocal  = new ThreadLocal<>();
    public static void main(String[] args) {
        for (int i=0;i<2;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName()+" has put data :"+data);
                    x.set(data); //当数据存储在当前线程上
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
            System.out.println("A from  "+Thread.currentThread().getName()+" get data : "+data);
            MyThreadScopeData instance = MyThreadScopeData.getInstance();
            System.out.println("A from  "+Thread.currentThread().getName()+" get data : "+instance.getName()+","+instance.getAge());
        }
    }

    static class B{
        public void get(){
            int data = x.get();
            System.out.println("B from  "+Thread.currentThread().getName()+" get data : "+data);
            MyThreadScopeData instance = MyThreadScopeData.getInstance();
            System.out.println("A from  "+Thread.currentThread().getName()+" get data : "+instance.getName()+","+instance.getAge());
        }
    }


}

class MyThreadScopeData{
    private static ThreadLocal<MyThreadScopeData> map = new ThreadLocal<>();
    private String name;
    private int age;
    private MyThreadScopeData(){ }
    private static MyThreadScopeData instance = new MyThreadScopeData();
    public static  MyThreadScopeData getInstance(){
        MyThreadScopeData instance = map.get();
        if(instance == null){
            instance = new MyThreadScopeData();
            map.set(instance);
        }
        return instance;
    }



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
