package Java多线程.java多线程与并发库高级应用.Demo17定时器异常是否继续运行;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: xuzaiya
 * @Date: 2020/5/18 10:22
 * @Description: # 类的描述
 */
public class TimerTest {
    private final static ScheduledExecutorService schedule = Executors.newSingleThreadScheduledExecutor();
    public static void main(String[] args) {
        /*schedule.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try{
                    int[]s = new int[1];
                    System.out.println("ok");
                    System.out.println(s[1]);
                }catch (Exception e){
                    System.out.println("error");
                }
            }
        },0,2, TimeUnit.SECONDS);*/

        try{
        schedule.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {

                    int[]s = new int[1];
                    System.out.println("ok");
                    System.out.println(s[1]);

            }
        },0,2, TimeUnit.SECONDS);

        }catch (Exception e){
            System.out.println("error");
        }

    }
}
