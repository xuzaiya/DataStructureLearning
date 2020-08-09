package Java多线程.java多线程与并发库Demo.入门案例四线程插队;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new EmergencyThread(),"线程一");
        t.start();
        for (int i=1;i<6;i++){
            System.out.println(Thread.currentThread().getName()+"输出："+i);
            if (i==2){
                t.join();

            }
            Thread.sleep(500);
        }
    }
}
