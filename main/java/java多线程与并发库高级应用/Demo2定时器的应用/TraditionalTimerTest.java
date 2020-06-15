package java多线程与并发库高级应用.Demo2定时器的应用;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TraditionalTimerTest {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("bombing!");
            }
        },2000,3000); //第一次定时任务是2秒以后，然后每个3秒执行一次任务


        while(true){
            System.out.println(new Date().getSeconds());
            Thread.sleep(1000);
        }
    }
}
