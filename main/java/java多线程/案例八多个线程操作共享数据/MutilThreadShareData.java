package java多线程.案例八多个线程操作共享数据;

public class MutilThreadShareData {
    public static void main(String[] args) {
        final ShareData data = new ShareData();

        new Thread(new MyRunnable1(data)).start();
        new Thread(new MyRunnable1(data)).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                data.decrement();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                data.increment();
            }
        }).start();


    }

    static class MyRunnable1 implements Runnable{
        private  ShareData data;

        public MyRunnable1(ShareData data){
            this.data = data;
        }
        public void run(){

        }
    }

    static class ShareData {
        private int j=0;

        public synchronized void increment(){
            j++;
        }

        public synchronized void decrement(){
            j--;
        }


    }
}
