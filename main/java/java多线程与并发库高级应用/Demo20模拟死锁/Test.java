package java多线程与并发库高级应用.Demo20模拟死锁;

/**
 * @Auther: xuzaiya
 * @Date: 2020/6/10 16:28
 * @Description: # 类的描述
 */
public class Test {
    public static void main(String[] args) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (B.class) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (A.class) {

                    }
                }
            }
        }).start();




        new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (A.class) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    synchronized (B.class) {

                    }
                }

            }
        }).start();









    }
}




class A {

}

class B {

}
