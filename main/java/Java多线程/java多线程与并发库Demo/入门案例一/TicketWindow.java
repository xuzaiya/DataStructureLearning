package Java多线程.java多线程与并发库Demo.入门案例一;

public class TicketWindow implements Runnable {
    private int tickets  =100;
    public void run(){
        while(true){
            if (tickets>0){
                Thread th = Thread.currentThread();
                String th_name = th.getName();
                System.out.println(th_name+"正在发售第"+tickets--+"张票");
            }
        }
    }
}
