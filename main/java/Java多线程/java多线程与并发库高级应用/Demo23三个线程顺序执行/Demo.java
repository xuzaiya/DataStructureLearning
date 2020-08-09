package Java多线程.java多线程与并发库高级应用.Demo23三个线程顺序执行;

/**
 * @author xuzaiya
 * @2020/7/22 13:57
 * 文件说明:
 */
public class Demo {
    public static void main(String[] args) {
        final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1");
            }
        });

        final Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //引用t1线程，等待t1线程执行完成
                try {
                    t1.join();
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
                System.out.println("t2");
            }
        });


        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t3");
            }
        });
        t3.start();
        t2.start();
        t1.start();
    }
}
