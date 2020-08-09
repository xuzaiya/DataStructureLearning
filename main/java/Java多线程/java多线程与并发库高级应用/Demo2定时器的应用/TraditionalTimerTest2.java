package Java多线程.java多线程与并发库高级应用.Demo2定时器的应用;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TraditionalTimerTest2 {
    static int count = 0;
    public static void main(String[] args) throws InterruptedException {

        class MyTimerTask extends TimerTask{


            @Override
            public void run() {
                count = (count+1)%2;
                System.out.println("bombing!");
                new Timer().schedule(new MyTimerTask(),2000+2000*count);

            }
        }

        new Timer().schedule(new MyTimerTask(), 2000);





        while(true){
            System.out.println(new Date().getSeconds());
            Thread.sleep(1000);
        }
    }
}
