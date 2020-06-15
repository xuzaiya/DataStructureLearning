package java多线程与并发库高级应用.Demo6多个线程之间访问共享数据方式;
/*
* 设计4个线程，其中两个线程每次对j增加1，另外2个线程对j每次减少1
*
* 多个线程之间访问共享数据的方式
*
* */
public class MultiThreadShareData {
    public static void main(String[] args) {
        ShareData data = new ShareData();
        MyRunnable1 myRunnable1 = new MyRunnable1(data);
        MyRunnable2 myRunnable2 = new MyRunnable2(data);

        new Thread(myRunnable1).start();
        new Thread(myRunnable2).start();

      /*  new Thread(new Runnable() {
            @Override
            public void run() {
                data.increment();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                data.decrement();
            }
        }).start();*/

    }
}

class ShareData {
    public  int count = 100;

    public void increment(){
        count++;
    }

    public void decrement(){
        count--;
    }
}

class MyRunnable1 implements Runnable{

    private ShareData data;
    public MyRunnable1 (ShareData data){
        this.data = data;
    }
    @Override
    public void run() {
        while(data.count>0){
            data.decrement();
            System.out.println(data.count);
        }

    }
}


class MyRunnable2 implements Runnable{

    private ShareData data;
    public MyRunnable2 (ShareData data){
        this.data = data;
    }
    @Override
    public void run() {
        while(data.count<0)
        data.increment();
        System.out.println(data.count);
    }
}