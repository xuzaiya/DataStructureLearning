package java多线程与并发库高级应用.Demo17定时器异常是否继续运行;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: xuzaiya
 * @Date: 2020/5/22 09:51
 * @Description: # 类的描述
 */
public class SynchronizedTest {

    private static ReentrantLock reentrantLock = new ReentrantLock(true);
    private final static ScheduledExecutorService schedule = Executors.newSingleThreadScheduledExecutor();
    public final static Object object = new Object();
    public  static boolean first = true;
    public static void main(String[] args) {

        schedule.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try{

                    function1();
                }catch (Exception e){
                    System.out.println("异常");
                }
            }
        },0,16, TimeUnit.SECONDS);


        new Thread(){
            public void run(){
                try {


                        function2();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();




    }
    public static void function1()  {


            for (int i = 0 ;i<10;i++){
                reentrantLock.lock();
                try {

                    System.out.println("yangxu");
                    Thread.sleep(50);
                    if(i==6 ){
                        int j = i/0;
                        return ;
                    }



                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {

                    reentrantLock.unlock();
                }


            }





    }

    public static void function2()  {



            for (int i = 0;i<100;i++){
                reentrantLock.lock();
                try {
                    System.out.println("zengyang");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    reentrantLock.unlock();
                }

            }




    }
}
